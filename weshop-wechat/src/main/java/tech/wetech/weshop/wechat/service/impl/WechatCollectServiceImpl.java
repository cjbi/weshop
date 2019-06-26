package tech.wetech.weshop.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.utils.Constants;
import tech.wetech.weshop.user.api.CollectApi;
import tech.wetech.weshop.user.bo.GoodsCollectBO;
import tech.wetech.weshop.user.po.Collect;
import tech.wetech.weshop.wechat.service.WechatCollectService;
import tech.wetech.weshop.wechat.vo.CollectAddOrDeleteParamVO;
import tech.wetech.weshop.wechat.vo.CollectAddOrDeleteResultVO;

import java.util.List;

@Service
public class WechatCollectServiceImpl implements WechatCollectService {

    @Autowired
    private CollectApi collectApi;

    @Override
    public CollectAddOrDeleteResultVO addOrDelete(CollectAddOrDeleteParamVO collectAddOrDeleteParamDTO) {
        Collect collect = collectApi.queryOne(new Collect() {{
            setTypeId(collectAddOrDeleteParamDTO.getTypeId());
            setValueId(collectAddOrDeleteParamDTO.getValueId());
            setUserId(Constants.CURRENT_USER_ID);
        }}).getData();
        CollectAddOrDeleteResultVO.HandleType type = CollectAddOrDeleteResultVO.HandleType.add;
        //添加收藏
        if (collect == null) {
            collectApi.create(new Collect() {{
                setTypeId(collectAddOrDeleteParamDTO.getTypeId());
                setValueId(collectAddOrDeleteParamDTO.getValueId());
                setUserId(Constants.CURRENT_USER_ID);
            }});
        } else {
            collectApi.deleteById(collect.getId());
            type = CollectAddOrDeleteResultVO.HandleType.delete;
        }
        return new CollectAddOrDeleteResultVO(type);
    }

    @Override
    public List<GoodsCollectBO> queryGoodsCollectList() {
        return collectApi.queryGoodsCollectList().getData();
    }
}
