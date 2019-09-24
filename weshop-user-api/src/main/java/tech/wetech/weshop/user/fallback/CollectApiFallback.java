package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.user.api.CollectApi;
import tech.wetech.weshop.user.dto.GoodsCollectDTO;
import tech.wetech.weshop.user.po.Collect;

import java.util.List;

@Component
public class CollectApiFallback extends ApiFallback<Collect> implements CollectApi {

    @Override
    public ResultWrapper<List<GoodsCollectDTO>> queryGoodsCollectList(Integer userId) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }
}
