package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.FootprintMapper;
import tech.wetech.weshop.po.FootprintPO;
import tech.wetech.weshop.query.FootprintPageQuery;
import tech.wetech.weshop.service.FootprintService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class FootprintServiceImpl implements FootprintService {

    @Autowired
    private FootprintMapper footprintMapper;

    @Override
    public PageInfo<FootprintPO> queryFootprintPageInfo(FootprintPageQuery footprintPageQuery) {
        Weekend<FootprintPO> example = Weekend.of(FootprintPO.class);
        WeekendCriteria<FootprintPO, Object> criteria = example.weekendCriteria();
        if (footprintPageQuery.getUserId() != null) {
            criteria.andEqualTo(FootprintPO::getUserId, footprintPageQuery.getUserId());
        }
        if (footprintPageQuery.getGoodsId() != null) {
            criteria.andEqualTo(FootprintPO::getGoodsId, footprintPageQuery.getGoodsId());
        }
        return PageHelper.startPage(footprintPageQuery.getPageNum(), footprintPageQuery.getPageSize())
                .doSelectPageInfo(() -> footprintMapper.selectByExample(example));
    }
}
