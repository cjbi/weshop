package tech.wetech.weshop.user.service;

import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.user.dto.GoodsCollectDTO;
import tech.wetech.weshop.user.po.Collect;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface CollectService extends IService<Collect> {

    List<GoodsCollectDTO> queryGoodsCollectList(Integer userId);

}
