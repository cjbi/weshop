package tech.wetech.weshop.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.utils.Criteria;
import tech.wetech.weshop.user.api.CollectApi;
import tech.wetech.weshop.user.dto.GoodsCollectDTO;
import tech.wetech.weshop.user.po.Collect;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.wechat.service.WechatCollectService;
import tech.wetech.weshop.wechat.utils.JwtHelper;
import tech.wetech.weshop.wechat.vo.CollectAddOrDeleteParamVO;
import tech.wetech.weshop.wechat.vo.CollectAddOrDeleteResultVO;

import java.util.List;

@Service
public class WechatCollectServiceImpl implements WechatCollectService {

    @Autowired
    private CollectApi collectApi;

    @Override
    public CollectAddOrDeleteResultVO addOrDelete(CollectAddOrDeleteParamVO dto) {
        User userInfo = JwtHelper.getUserInfo();
        List<Collect> data = collectApi.queryByCriteria(
                Criteria.of(Collect.class).andEqualTo(Collect::getTypeId, dto.getTypeId())
                        .andEqualTo(Collect::getValueId, dto.getValueId())
                        .andEqualTo(Collect::getUserId, userInfo.getId())).getData();
        //添加收藏
        if (data.size() == 0) {
            collectApi.create(new Collect()
                    .setTypeId(dto.getTypeId())
                    .setValueId(dto.getValueId())
                    .setUserId(userInfo.getId()));
            return new CollectAddOrDeleteResultVO(true);
        } else {
            collectApi.delete(new Collect()
                    .setTypeId(dto.getTypeId())
                    .setValueId(dto.getValueId())
                    .setUserId(userInfo.getId()));
            return new CollectAddOrDeleteResultVO(false);
        }

    }

    @Override
    public List<GoodsCollectDTO> queryGoodsCollectList() {
        User userInfo = JwtHelper.getUserInfo();
        return collectApi.queryGoodsCollectList(userInfo.getId()).getData();
    }
}
