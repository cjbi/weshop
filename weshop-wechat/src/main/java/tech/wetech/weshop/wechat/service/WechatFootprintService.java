package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.user.bo.GoodsFootprintBO;

import java.util.List;

public interface WechatFootprintService {

    List<List<GoodsFootprintBO>> queryGoodsFootprintTimeLine();
}
