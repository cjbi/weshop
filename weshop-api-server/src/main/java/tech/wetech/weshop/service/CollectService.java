package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.CollectPO;
import tech.wetech.weshop.query.CollectPageQuery;

/**
 * @author cjbi
 */
public interface CollectService {

    /**
     * 查询会员收藏
     * @param collectPageQuery
     * @return
     */
    PageInfo<CollectPO> queryCollectPageInfo(CollectPageQuery collectPageQuery);

}
