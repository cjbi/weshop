package tech.wetech.weshop.user.service;

import org.springframework.web.bind.annotation.RequestBody;
import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.user.bo.GoodsCollectBO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteParamDTO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteResultDTO;
import tech.wetech.weshop.user.po.Collect;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface CollectService extends IService<Collect> {

    CollectAddOrDeleteResultDTO addOrDelete(@RequestBody CollectAddOrDeleteParamDTO collectAddOrDeleteParamDTO);

    List<GoodsCollectBO> queryGoodsCollectList();

}
