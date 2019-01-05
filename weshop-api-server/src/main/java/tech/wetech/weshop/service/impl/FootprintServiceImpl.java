package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.bo.GoodsFootprintBO;
import tech.wetech.weshop.mapper.FootprintMapper;
import tech.wetech.weshop.po.Footprint;
import tech.wetech.weshop.service.FootprintService;
import tech.wetech.weshop.utils.Constants;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@Service
public class FootprintServiceImpl extends BaseService<Footprint> implements FootprintService {

    @Autowired
    private FootprintMapper footprintMapper;

    @Override
    public Map<String, List<GoodsFootprintBO>> queryGoodsFootprintTimeLine() {
        List<GoodsFootprintBO> goodsFootprintList = footprintMapper.selectGoodsFootprintByUserId(Constants.CURRENT_USER_ID);

        Map<String, List<GoodsFootprintBO>> timeLineMap = new LinkedHashMap<>();

        goodsFootprintList.stream()
                .collect(Collectors.groupingBy(gf -> gf.getCreateTime()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    Long d1 = e1.getKey().toEpochDay();
                    Long d2 = e2.getKey().toEpochDay();
                    return d2.compareTo(d1);
                }).forEachOrdered(e -> {
            if (LocalDate.now().isEqual(e.getKey())) {
                timeLineMap.put("今天", e.getValue());
            } else if (LocalDate.now().minusDays(1).isEqual(e.getKey())) {
                timeLineMap.put("昨天", e.getValue());
            } else if (LocalDate.now().minusDays(2).isEqual(e.getKey())) {
                timeLineMap.put("前天", e.getValue());
            } else {
                timeLineMap.put(e.getKey().toString(), e.getValue());
            }
        });
        return timeLineMap;
    }
}
