package tech.wetech.weshop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.service.BaseService;
import tech.wetech.weshop.user.dto.GoodsCollectDTO;
import tech.wetech.weshop.user.mapper.CollectMapper;
import tech.wetech.weshop.user.po.Collect;
import tech.wetech.weshop.user.service.CollectService;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@RestController
public class CollectServiceImpl extends BaseService<Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public List<GoodsCollectDTO> queryGoodsCollectList(Integer userId) {
        return collectMapper.selectGoodsCollectByUserId(userId);
    }
}
