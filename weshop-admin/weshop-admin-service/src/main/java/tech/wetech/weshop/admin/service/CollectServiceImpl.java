package tech.wetech.weshop.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.bo.GoodsCollectBO;
import tech.wetech.weshop.mapper.CollectMapper;
import tech.wetech.weshop.po.Collect;
import tech.wetech.weshop.service.BaseService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.admin.dto.CollectAddOrDeleteParamDTO;
import tech.wetech.weshop.admin.dto.CollectAddOrDeleteResultDTO;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@Service
public class CollectServiceImpl extends BaseService<Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public CollectAddOrDeleteResultDTO addOrDelete(CollectAddOrDeleteParamDTO collectAddOrDeleteParamDTO) {
        Collect collect = collectMapper.selectOne(new Collect() {{
            setTypeId(collectAddOrDeleteParamDTO.getTypeId());
            setValueId(collectAddOrDeleteParamDTO.getValueId());
            setUserId(Constants.CURRENT_USER_ID);
        }});
        CollectAddOrDeleteResultDTO.HandleType type = CollectAddOrDeleteResultDTO.HandleType.add;
        //添加收藏
        if (collect == null) {
            collectMapper.insertSelective(new Collect() {{
                setTypeId(collectAddOrDeleteParamDTO.getTypeId());
                setValueId(collectAddOrDeleteParamDTO.getValueId());
                setUserId(Constants.CURRENT_USER_ID);
            }});
        } else {
            collectMapper.deleteByPrimaryKey(collect.getId());
            type = CollectAddOrDeleteResultDTO.HandleType.delete;
        }
        return new CollectAddOrDeleteResultDTO(type);
    }

    @Override
    public List<GoodsCollectBO> queryGoodsCollectList() {
        return collectMapper.selectGoodsCollectByUserId(Constants.CURRENT_USER_ID);
    }
}
