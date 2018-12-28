package tech.wetech.weshop.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.exception.BizException;
import tech.wetech.weshop.mapper.*;
import tech.wetech.weshop.po.*;
import tech.wetech.weshop.service.OrderService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.vo.OrderSubmitVO;
import tech.wetech.weshop.vo.OrderVO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    public OrderVO queryOrderDetail(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);

        List<OrderGoods> orderGoodsList = orderGoodsMapper.select(new OrderGoods() {{
            setOrderId(orderId);
        }});

        OrderExpress orderExpress = orderExpressMapper.selectOne(new OrderExpress() {{
            setOrderId(orderId);
        }});

        return new OrderVO(order, orderGoodsList, orderExpress);
    }

    @Override
    public Order submitOrder(OrderSubmitVO orderSubmitVO) {
        Address checkedAddress = addressMapper.selectByPrimaryKey(orderSubmitVO.getAddressId());
        if (checkedAddress == null) {
            throw new BizException("请选择收货地址");
        }

        //获取要购买的商品
        List<Cart> checkedGoodsList = cartMapper.select(new Cart() {{
            setUserId(Constants.CURRENT_USER_ID);
            setSessionId(Constants.SESSION_ID);
            setChecked(true);
        }});
        if (checkedGoodsList.isEmpty()) {
            throw new BizException("请选择商品");
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
        if (orderSubmitVO.getCouponId() != null) {
            //计算优惠券的价格 未实现
        }

        // 订单价格计算  实际价格 = 商品价格 + 运费价格 - 优惠券价格
        BigDecimal orderTotalPrice = goodsTotalPrice.add(freightPrice).subtract(couponPrice);
        // 减去其它支付的金额后，要实际支付的金额
        BigDecimal actualPrice = orderTotalPrice.subtract(new BigDecimal(0.00));
        Date currentTime = new Date();

        Order orderInfo = new Order();
        //TODO
        DateTime.now();
        orderInfo.setOrderSN(null);
        return null;
    }


}
