package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.bo.GoodsCollectBO;
import tech.wetech.weshop.mapper.CollectMapper;
import tech.wetech.weshop.po.Collect;
import tech.wetech.weshop.service.CollectService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.vo.CollectAddOrDeleteParamVO;
import tech.wetech.weshop.vo.CollectAddOrDeleteResultVO;

import java.util.List;

/**
 * @author cjbi
 */
@Service
public class CollectServiceImpl extends BaseService<Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public CollectAddOrDeleteResultVO addOrDelete(CollectAddOrDeleteParamVO collectAddOrDeleteParamVO) {
        Collect collect = collectMapper.selectOne(new Collect() {{
            setTypeId(collectAddOrDeleteParamVO.getTypeId());
            setValueId(collectAddOrDeleteParamVO.getValueId());
            setUserId(Constants.CURRENT_USER_ID);
        }});
        CollectAddOrDeleteResultVO.HandleType type = CollectAddOrDeleteResultVO.HandleType.add;
        //添加收藏
        if (collect == null) {
            collectMapper.insertSelective(new Collect() {{
                setTypeId(collectAddOrDeleteParamVO.getTypeId());
                setValueId(collectAddOrDeleteParamVO.getValueId());
                setUserId(Constants.CURRENT_USER_ID);
            }});
        } else {
            collectMapper.deleteByPrimaryKey(collect.getId());
            type = CollectAddOrDeleteResultVO.HandleType.delete;
        }
        return new CollectAddOrDeleteResultVO(type);
    }

    @Override
    public List<GoodsCollectBO> queryGoodsCollectList() {
        return collectMapper.selectGoodsCollectByUserId(Constants.CURRENT_USER_ID);
    }
}
