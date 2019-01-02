package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Collect;
import tech.wetech.weshop.vo.AddOrDeleteParamVO;
import tech.wetech.weshop.vo.AddOrDeleteResultVO;

/**
 * @author cjbi
 */
public interface CollectService extends IService<Collect> {

    AddOrDeleteResultVO addOrDelete(AddOrDeleteParamVO addOrDeleteParamVO);

}
