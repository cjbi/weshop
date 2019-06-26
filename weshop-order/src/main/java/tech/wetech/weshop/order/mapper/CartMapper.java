package tech.wetech.weshop.order.mapper;

import tech.wetech.weshop.common.utils.MyMapper;
import tech.wetech.weshop.order.po.Cart;

public interface CartMapper extends MyMapper<Cart> {

    int updateNumberById(Integer number, Integer id);

}