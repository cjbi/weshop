package tech.wetech.weshop.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.user.api.FootprintApi;
import tech.wetech.weshop.user.dto.GoodsFootprintDTO;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.wechat.service.WechatFootprintService;
import tech.wetech.weshop.wechat.utils.JwtHelper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WechatFootprintServiceImpl implements WechatFootprintService {

    @Autowired
    private FootprintApi footprintApi;

    @Override
    public List<List<GoodsFootprintDTO>> queryGoodsFootprintTimeLine() {
        User userInfo = JwtHelper.getUserInfo();
        List<GoodsFootprintDTO> goodsFootprintList = footprintApi.queryGoodsFootprintByUserId(userInfo.getId()).getData();

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
