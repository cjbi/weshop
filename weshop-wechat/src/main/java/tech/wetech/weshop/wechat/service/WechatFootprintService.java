package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.user.dto.GoodsFootprintDTO;

import java.util.List;

public interface WechatFootprintService {

    List<List<GoodsFootprintDTO>> queryGoodsFootprintTimeLine();
}
