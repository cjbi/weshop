package tech.wetech.weshop.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.user.api.CollectApi;
import tech.wetech.weshop.user.bo.GoodsCollectBO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteParamDTO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteResultDTO;
import tech.wetech.weshop.user.po.Collect;
import tech.wetech.weshop.user.service.CollectService;

import java.util.List;

@RestController
public class CollectController extends BaseApi<Collect> implements CollectApi {

    @Autowired
    private CollectService collectService;

    @Override
    public CollectAddOrDeleteResultDTO addOrDelete(CollectAddOrDeleteParamDTO collectAddOrDeleteParamDTO) {
        return collectService.addOrDelete(collectAddOrDeleteParamDTO);
    }

    @Override
    public List<GoodsCollectBO> queryGoodsCollectList() {
        return collectService.queryGoodsCollectList();
    }
}
