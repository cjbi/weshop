package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.SearchHistoryMapper;
import tech.wetech.weshop.po.SearchHistoryPO;
import tech.wetech.weshop.query.SearchHistoryPageQuery;
import tech.wetech.weshop.service.SearchHistoryService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {

    @Autowired
    private SearchHistoryMapper searchHistoryMapper;

    @Override
    public PageInfo<SearchHistoryPO> querySearchHistoryPageInfo(SearchHistoryPageQuery searchHistoryPageQuery) {
        Weekend<SearchHistoryPO> example = Weekend.of(SearchHistoryPO.class);
        WeekendCriteria<SearchHistoryPO, Object> criteria = example.weekendCriteria();
        if (searchHistoryPageQuery.getUserId() != null) {
            criteria.andEqualTo(SearchHistoryPO::getUserId, searchHistoryPageQuery.getUserId());
        }
        if (searchHistoryPageQuery.getKeyword() != null) {
            criteria.andEqualTo(SearchHistoryPO::getKeyword, searchHistoryPageQuery.getKeyword());
        }
        return PageHelper.startPage(searchHistoryPageQuery.getPageNum(), searchHistoryPageQuery.getPageSize())
                .doSelectPageInfo(() -> searchHistoryMapper.selectByExample(example));
    }
}
