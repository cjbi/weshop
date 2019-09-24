package tech.wetech.weshop.goods.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.goods.api.CategoryApi;
import tech.wetech.weshop.goods.po.Category;

import java.util.List;

@Component
public class CategoryApiFallback extends ApiFallback<Category> implements CategoryApi {
    @Override
    public ResultWrapper<List<Integer>> queryIdsByParentId(Integer parentId) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<List<Integer>> queryParentIdsByIdIn(List<Integer> ids) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<List<Category>> queryByIdIn(List<Integer> ids) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }
}
