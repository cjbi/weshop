package tech.wetech.weshop.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.user.api.CollectApi;
import tech.wetech.weshop.user.bo.GoodsCollectBO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteParamDTO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteResultDTO;
import tech.wetech.weshop.user.po.Collect;
import tech.wetech.weshop.user.service.CollectService;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController extends BaseApi<Collect> implements CollectApi {

    @Autowired
    private CollectService collectService;

    @Override
    public Result<CollectAddOrDeleteResultDTO> addOrDelete(CollectAddOrDeleteParamDTO collectAddOrDeleteParamDTO) {
        return Result.success(collectService.addOrDelete(collectAddOrDeleteParamDTO));
    }

    @Override
    public Result<List<GoodsCollectBO>> queryGoodsCollectList() {
        return Result.success(collectService.queryGoodsCollectList());
    }
}
