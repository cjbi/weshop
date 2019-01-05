package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Collect;
import tech.wetech.weshop.vo.CollectAddOrDeleteParamVO;
import tech.wetech.weshop.vo.CollectAddOrDeleteResultVO;

/**
 * @author cjbi
 */
public interface CollectService extends IService<Collect> {

    CollectAddOrDeleteResultVO addOrDelete(CollectAddOrDeleteParamVO collectAddOrDeleteParamVO);

}
