package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.CollectMapper;
import tech.wetech.weshop.po.Collect;
import tech.wetech.weshop.service.CollectService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.vo.AddOrDeleteParamVO;
import tech.wetech.weshop.vo.AddOrDeleteResultVO;

/**
 * @author cjbi
 */
@Service
public class CollectServiceImpl extends BaseService<Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public AddOrDeleteResultVO addOrDelete(AddOrDeleteParamVO addOrDeleteParamVO) {
        Collect collect = collectMapper.selectOne(new Collect() {{
            setTypeId(addOrDeleteParamVO.getTypeId());
            setValueId(addOrDeleteParamVO.getValueId());
            setUserId(Constants.CURRENT_USER_ID);
        }});
        AddOrDeleteResultVO.HandleType handleType = AddOrDeleteResultVO.HandleType.add;
        //添加收藏
        if (collect == null) {
            collectMapper.insertSelective(new Collect() {{
                setTypeId(addOrDeleteParamVO.getTypeId());
                setValueId(addOrDeleteParamVO.getValueId());
                setUserId(Constants.CURRENT_USER_ID);
            }});
        } else {
            collectMapper.deleteByPrimaryKey(collect.getId());
            handleType = AddOrDeleteResultVO.HandleType.delete;
        }
        return new AddOrDeleteResultVO(handleType);
    }
}
