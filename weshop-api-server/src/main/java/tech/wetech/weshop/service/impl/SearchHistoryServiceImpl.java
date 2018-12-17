package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.SearchHistoryMapper;
import tech.wetech.weshop.domain.SearchHistory;
import tech.wetech.weshop.query.SearchHistoryPageQuery;
import tech.wetech.weshop.service.SearchHistoryService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class SearchHistoryServiceImpl extends BaseService<SearchHistory> implements SearchHistoryService {
}
