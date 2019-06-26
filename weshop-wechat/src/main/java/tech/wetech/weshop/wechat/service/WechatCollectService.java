package tech.wetech.weshop.wechat.service;

import org.springframework.web.bind.annotation.RequestBody;
import tech.wetech.weshop.user.bo.GoodsCollectBO;
import tech.wetech.weshop.wechat.vo.CollectAddOrDeleteParamVO;
import tech.wetech.weshop.wechat.vo.CollectAddOrDeleteResultVO;

import java.util.List;

public interface WechatCollectService {

    CollectAddOrDeleteResultVO addOrDelete(@RequestBody CollectAddOrDeleteParamVO collectAddOrDeleteParamDTO);

    List<GoodsCollectBO> queryGoodsCollectList();

}
