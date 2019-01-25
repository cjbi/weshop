package tech.wetech.weshop.admin.service;

import tech.wetech.weshop.bo.GoodsCollectBO;
import tech.wetech.weshop.po.Collect;
import tech.wetech.weshop.admin.dto.CollectAddOrDeleteParamDTO;
import tech.wetech.weshop.admin.dto.CollectAddOrDeleteResultDTO;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface CollectService extends IService<Collect> {

    CollectAddOrDeleteResultDTO addOrDelete(CollectAddOrDeleteParamDTO collectAddOrDeleteParamDTO);

    List<GoodsCollectBO> queryGoodsCollectList();

}
