package tech.wetech.weshop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.service.BaseService;
import tech.wetech.weshop.user.dto.GoodsFootprintDTO;
import tech.wetech.weshop.user.mapper.FootprintMapper;
import tech.wetech.weshop.user.po.Footprint;
import tech.wetech.weshop.user.service.FootprintService;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@Service
public class FootprintServiceImpl extends BaseService<Footprint> implements FootprintService {

    @Autowired
    private FootprintMapper footprintMapper;

    @Override
    public List<GoodsFootprintDTO> queryGoodsFootprintByUserId(Integer userId) {
        return footprintMapper.selectGoodsFootprintByUserId(userId);
    }
}
