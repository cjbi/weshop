package tech.wetech.weshop.order.mapper;

import tech.wetech.weshop.order.po.Cart;
import tech.wetech.weshop.utils.MyMapper;

public interface CartMapper extends MyMapper<Cart> {

    int incrementNumberById(Integer id);

}