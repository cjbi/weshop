package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.fallback.ApiFallback;
import tech.wetech.weshop.user.api.CollectApi;
import tech.wetech.weshop.user.bo.GoodsCollectBO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteParamDTO;
import tech.wetech.weshop.user.dto.CollectAddOrDeleteResultDTO;
import tech.wetech.weshop.user.po.Collect;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@Component
public class CollectApiFallback extends ApiFallback<Collect> implements CollectApi {
    @Override
    public Result<CollectAddOrDeleteResultDTO> addOrDelete(CollectAddOrDeleteParamDTO collectAddOrDeleteParamDTO) {
        return null;
    }

    @Override
    public Result<List<GoodsCollectBO>> queryGoodsCollectList() {
        return null;
    }
}
