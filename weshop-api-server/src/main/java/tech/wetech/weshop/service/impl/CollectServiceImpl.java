package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.CollectMapper;
import tech.wetech.weshop.po.Collect;
import tech.wetech.weshop.query.CollectPageQuery;
import tech.wetech.weshop.service.CollectService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;


    @Override
    public PageInfo<Collect> queryCollectPageInfo(CollectPageQuery collectPageQuery) {
        Weekend<Collect> example = Weekend.of(Collect.class);
        WeekendCriteria<Collect, Object> criteria = example.weekendCriteria();
        if (collectPageQuery.getUserId() != null) {
            criteria.andEqualTo(Collect::getUserId, collectPageQuery.getUserId());
        }
        if (collectPageQuery.getValueId() != null) {
            criteria.andEqualTo(Collect::getValueId, collectPageQuery.getValueId());
        }
        return PageHelper.startPage(collectPageQuery.getPageNum(), collectPageQuery.getPageSize())
                .doSelectPageInfo(() -> collectMapper.selectByExample(example));
    }
}
