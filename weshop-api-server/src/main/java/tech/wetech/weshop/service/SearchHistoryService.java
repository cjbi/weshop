package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.SearchHistoryPO;
import tech.wetech.weshop.query.SearchHistoryPageQuery;

/**
 * @author cjbi
 */
public interface SearchHistoryService {

    /**
     * 分页查询搜索历史
     * @param searchHistoryPageQuery
     * @return
     */
    PageInfo<SearchHistoryPO> querySearchHistoryPageInfo(SearchHistoryPageQuery searchHistoryPageQuery);

}
