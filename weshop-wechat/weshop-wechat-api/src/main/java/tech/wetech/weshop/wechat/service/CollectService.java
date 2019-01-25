package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.wechat.dto.CollectAddOrDeleteParamDTO;
import tech.wetech.weshop.wechat.dto.CollectAddOrDeleteResultDTO;
import tech.wetech.weshop.bo.GoodsCollectBO;
import tech.wetech.weshop.po.Collect;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface CollectService extends IService<Collect> {

    CollectAddOrDeleteResultDTO addOrDelete(CollectAddOrDeleteParamDTO collectAddOrDeleteParamDTO);

    List<GoodsCollectBO> queryGoodsCollectList();

}
