package tech.wetech.weshop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.enums.ResultCodeEnum;
import tech.wetech.weshop.exception.BizException;
import tech.wetech.weshop.mapper.*;
import tech.wetech.weshop.po.*;
import tech.wetech.weshop.query.OrderQuery;
import tech.wetech.weshop.service.OrderService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.IdGenerator;
import tech.wetech.weshop.vo.HandleOptionVO;
import tech.wetech.weshop.vo.OrderListVO;
import tech.wetech.weshop.vo.OrderSubmitParamVO;
import tech.wetech.weshop.vo.OrderVO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@Service
public class OrderServiceImpl extends BaseService<Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private OrderExpressMapper orderExpressMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<OrderListVO> queryOrderPageInfo(OrderQuery orderQuery) {
        PageHelper.startPage(orderQuery.getPageNum(), orderQuery.getPageSize());
        List<Order> orderList = orderMapper.selectAll();
        List<OrderListVO> orderVOList = orderList.stream()
                .map(OrderListVO::new)
                .collect(Collectors.toList());
        return orderVOList;
    }

    @Override
    public OrderVO queryOrderDetail(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);

        List<OrderGoods> orderGoodsList = orderGoodsMapper.select(new OrderGoods().setOrderId(orderId));

        OrderExpress orderExpress = orderExpressMapper.selectOne(new OrderExpress().setOrderId(orderId));

        return new OrderVO(order, orderGoodsList, orderExpress, new HandleOptionVO(order.getOrderStatus()));
    }

    @Override
    public Order submitOrder(OrderSubmitParamVO orderSubmitParamVO) {
        Address checkedAddress = addressMapper.selectByPrimaryKey(orderSubmitParamVO.getAddressId());
        if (checkedAddress == null) {
            throw new BizException(ResultCodeEnum.PLEASE_SELECT_SHIPPING_ADDRESS);
        }

        //获取要购买的商品
        List<Cart> checkedGoodsList = cartMapper.select(new Cart() {{
            setUserId(Constants.CURRENT_USER_ID);
            setSessionId(Constants.SESSION_ID);
            setChecked(true);
        }});
        if (checkedGoodsList.isEmpty()) {
            throw new BizException(ResultCodeEnum.PLEASE_SELECT_SHIPPING_ADDRESS);
        }

        //统计商品总价
        BigDecimal goodsTotalPrice = BigDecimal.ZERO;
        for (Cart cart : checkedGoodsList) {
            goodsTotalPrice = goodsTotalPrice.add(
                    cart.getRetailPrice().multiply(new BigDecimal(cart.getNumber()))
            );
        }

        //运费价格
        BigDecimal freightPrice = BigDecimal.ZERO;

        //获取订单使用的优惠券
        BigDecimal couponPrice = BigDecimal.ZERO;
        if (orderSubmitParamVO.getCouponId() != null) {
            //计算优惠券的价格 未实现
        }

        // 订单价格计算  实际价格 = 商品价格 + 运费价格 - 优惠券价格
        BigDecimal orderTotalPrice = goodsTotalPrice.add(freightPrice).subtract(couponPrice);
        // 减去其它支付的金额后，要实际支付的金额
        BigDecimal actualPrice = orderTotalPrice.subtract(new BigDecimal(0.00));
        Date currentTime = new Date();

        Order orderInfo = new Order();
        orderInfo.setOrderSN(IdGenerator.INSTANCE.nextId());
        orderInfo.setUserId(Constants.CURRENT_USER_ID);

        //收货地址和运费
        orderInfo.setConsignee(checkedAddress.getName());
        orderInfo.setMobile(checkedAddress.getMobile());
        orderInfo.setProvince(checkedAddress.getProvinceId());
        orderInfo.setCity(checkedAddress.getCityId());
        orderInfo.setDistrict(checkedAddress.getDistrictId());
        orderInfo.setAddress(checkedAddress.getAddress());
        orderInfo.setFreightPrice(new BigDecimal(0.00));

        //留言
        orderInfo.setPostscript(orderSubmitParamVO.getPostscript());

        //使用优惠券
        orderInfo.setCouponId(0);
        orderInfo.setCouponPrice(couponPrice);
        orderInfo.setCreateTime(currentTime);
        orderInfo.setGoodsPrice(goodsTotalPrice);
        orderInfo.setOrderPrice(orderTotalPrice);
        orderInfo.setActualPrice(actualPrice);

        orderMapper.insertSelective(orderInfo);

        //统计商品总价
        List<OrderGoods> orderGoodsList = new LinkedList<>();
        for (Cart goodsItem : checkedGoodsList) {
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setOrderId(orderInfo.getId());
            orderGoods.setGoodsId(goodsItem.getGoodsId());
            orderGoods.setGoodsSn(goodsItem.getGoodsSn());
            orderGoods.setProductId(goodsItem.getProductId());
            orderGoods.setGoodsName(goodsItem.getGoodsName());
            orderGoods.setListPicUrl(goodsItem.getListPicUrl());
            orderGoods.setMarketPrice(goodsItem.getMarketPrice());
            orderGoods.setRetailPrice(goodsItem.getRetailPrice());
            orderGoods.setNumber(goodsItem.getNumber());
            orderGoods.setGoodsSpecificationNameValue(goodsItem.getGoodsSpecificationNameValue());
            orderGoods.setGoodsSpecificationIds(goodsItem.getGoodsSpecificationIds());

            orderGoodsList.add(orderGoods);
        }
        orderGoodsMapper.insertList(orderGoodsList);

        cartMapper.delete(new Cart() {{
            setUserId(Constants.CURRENT_USER_ID);
            setSessionId(Constants.SESSION_ID);
            setChecked(true);
        }});
        return orderInfo;
    }


}
