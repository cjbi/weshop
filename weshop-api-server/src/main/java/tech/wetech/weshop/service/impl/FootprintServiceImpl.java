package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.FootprintMapper;
import tech.wetech.weshop.po.Address;
import tech.wetech.weshop.po.Footprint;
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
    public PageInfo<Footprint> queryFootprintPageInfo(FootprintPageQuery footprintPageQuery) {
        Weekend<Footprint> example = Weekend.of(Footprint.class);
        WeekendCriteria<Footprint, Object> criteria = example.weekendCriteria();
        if (footprintPageQuery.getUserId() != null) {
            criteria.andEqualTo(Footprint::getUserId, footprintPageQuery.getUserId());
        }
        if (footprintPageQuery.getGoodsId() != null) {
            criteria.andEqualTo(Footprint::getGoodsId, footprintPageQuery.getGoodsId());
        }
        return PageHelper.startPage(footprintPageQuery.getPageNum(), footprintPageQuery.getPageSize())
                .doSelectPageInfo(() -> footprintMapper.selectByExample(example));
    }
}
