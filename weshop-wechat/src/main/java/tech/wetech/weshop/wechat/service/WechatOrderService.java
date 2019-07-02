package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.order.query.OrderQuery;
import tech.wetech.weshop.wechat.vo.OrderDetailVO;
import tech.wetech.weshop.wechat.vo.OrderListVO;
import tech.wetech.weshop.wechat.vo.OrderSubmitParamVO;
import tech.wetech.weshop.wechat.vo.OrderSubmitResultVO;

import java.util.List;

public interface WechatOrderService {

    /**
     * 分页查询订单数据
     *
     * @param orderQuery
     * @return
     */
    List<OrderListVO> queryOrderList(OrderQuery orderQuery);

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return
     */
    OrderDetailVO queryOrderDetail(Integer orderId);

    /**
     * 提交订单
     *
     * @param orderSubmitParamDTO
     * @return
     */
    OrderSubmitResultVO submitOrder(OrderSubmitParamVO orderSubmitParamDTO);

}
