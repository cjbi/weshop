package tech.wetech.weshop.order.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.enums.ResultCodeEnum;
import tech.wetech.weshop.exception.BizException;
import tech.wetech.weshop.order.dto.HandleOptionDTO;
import tech.wetech.weshop.order.dto.OrderDetailDTO;
import tech.wetech.weshop.order.dto.OrderListDTO;
import tech.wetech.weshop.order.dto.OrderSubmitParamDTO;
import tech.wetech.weshop.order.enums.OrderStatusEnum;
import tech.wetech.weshop.order.enums.PayStatusEnum;
import tech.wetech.weshop.order.mapper.CartMapper;
import tech.wetech.weshop.order.mapper.OrderExpressMapper;
import tech.wetech.weshop.order.mapper.OrderGoodsMapper;
import tech.wetech.weshop.order.mapper.OrderMapper;
import tech.wetech.weshop.order.po.Cart;
import tech.wetech.weshop.order.po.Order;
import tech.wetech.weshop.order.po.OrderExpress;
import tech.wetech.weshop.order.po.OrderGoods;
import tech.wetech.weshop.order.query.OrderQuery;
import tech.wetech.weshop.order.service.OrderService;
import tech.wetech.weshop.service.BaseService;
import tech.wetech.weshop.user.po.Address;
import tech.wetech.weshop.user.service.AddressService;
import tech.wetech.weshop.user.service.RegionService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.IdGenerator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author cjbi@outlook.com
 */
@RestController
public class OrderServiceImpl extends BaseService<Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private OrderExpressMapper orderExpressMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private AddressService addressService;

    @Autowired
    private RegionService regionService;

    @Override
    public List<OrderListDTO> queryOrderList(OrderQuery orderQuery) {
        PageHelper.startPage(orderQuery);
        List<Order> orderList = orderMapper.select(new Order().setUserId(Constants.CURRENT_USER_ID));
        List<OrderListDTO> orderVOList = new LinkedList<>();
        for (Order order : orderList) {
            OrderListDTO orderVO = new OrderListDTO(order)
                    .setGoodsList(orderGoodsMapper.select(new OrderGoods().setOrderId(order.getId())))
                    .setHandleOption(new HandleOptionDTO(order))
                    .setOrderStatusText(order.getPayStatus().getName());
            orderVOList.add(orderVO);
        }
        return orderVOList;
    }

    @Override
    public OrderDetailDTO queryOrderDetail(Integer orderId) {
        Order order = Optional.ofNullable(orderMapper.selectByPrimaryKey(orderId))
                .orElseThrow(() -> new BizException(ResultCodeEnum.RECORD_NOT_EXIST));

        OrderDetailDTO.OrderInfoVO orderInfoVO = new OrderDetailDTO.OrderInfoVO(order)
                .setOrderExpress(orderExpressMapper.selectOne(new OrderExpress().setOrderId(orderId)));

        orderInfoVO.setProvinceName(
                regionService.queryNameById(orderInfoVO.getProvince())
        ).setCityName(
                regionService.queryNameById(orderInfoVO.getCity())
        ).setDistrictName(
                regionService.queryNameById(orderInfoVO.getDistrict())
        );
        orderInfoVO.setFullRegion(
                orderInfoVO.getProvinceName() + orderInfoVO.getCityName() + orderInfoVO.getDistrictName()
        );

        List<OrderGoods> orderGoodsList = orderGoodsMapper.select(new OrderGoods().setOrderId(orderId));

        return new OrderDetailDTO(orderInfoVO, orderGoodsList, new HandleOptionDTO(order));
    }

    @Override
    public Order submitOrder(OrderSubmitParamDTO orderSubmitParamDTO) {
        Address checkedAddress = addressService.queryById(orderSubmitParamDTO.getAddressId());
        if (checkedAddress == null) {
            throw new BizException(ResultCodeEnum.PLEASE_SELECT_SHIPPING_ADDRESS);
        }

        //获取要购买的商品
        List<Cart> checkedGoodsList = cartMapper.select(
                new Cart()
                        .setUserId(Constants.CURRENT_USER_ID)
                        .setSessionId(Constants.SESSION_ID)
                        .setChecked(true)
        );
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
        if (orderSubmitParamDTO.getCouponId() != null) {
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
        orderInfo.setPostscript(orderSubmitParamDTO.getPostscript());

        //使用优惠券
        orderInfo.setCouponId(0);
        orderInfo.setCouponPrice(couponPrice);
        orderInfo.setCreateTime(currentTime);
        orderInfo.setGoodsPrice(goodsTotalPrice);
        orderInfo.setOrderPrice(orderTotalPrice);
        orderInfo.setActualPrice(actualPrice);

        //订单状态：提交订单
        orderInfo.setOrderStatus(OrderStatusEnum.SUBMIT_ORDER);
        //支付状态：待付款
        orderInfo.setPayStatus(PayStatusEnum.PENDING_REFUND);

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

        //清空购物车已购买商品
        cartMapper.delete(
                new Cart()
                        .setUserId(Constants.CURRENT_USER_ID)
                        .setSessionId(Constants.SESSION_ID)
                        .setChecked(true)
        );
        return orderInfo;
    }


}
