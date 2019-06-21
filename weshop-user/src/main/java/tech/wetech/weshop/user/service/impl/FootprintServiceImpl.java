package tech.wetech.weshop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.service.BaseService;
import tech.wetech.weshop.common.utils.Constants;
import tech.wetech.weshop.user.bo.GoodsFootprintBO;
import tech.wetech.weshop.user.mapper.FootprintMapper;
import tech.wetech.weshop.user.po.Footprint;
import tech.wetech.weshop.user.service.FootprintService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author cjbi@outlook.com
 */
@RestController
public class FootprintServiceImpl extends BaseService<Footprint> implements FootprintService {

    @Autowired
    private FootprintMapper footprintMapper;

    @Override
    public List<List<GoodsFootprintBO>> queryGoodsFootprintTimeLine() {
        List<GoodsFootprintBO> goodsFootprintList = footprintMapper.selectGoodsFootprintByUserId(Constants.CURRENT_USER_ID);

        return goodsFootprintList.stream()
                .collect(Collectors.groupingBy(gf -> gf.getCreateTime()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    Long d1 = e1.getKey().toEpochDay();
                    Long d2 = e2.getKey().toEpochDay();
                    return d2.compareTo(d1);
                }).map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
