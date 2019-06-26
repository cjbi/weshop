package tech.wetech.weshop.goods.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.goods.api.CategoryApi;
import tech.wetech.weshop.goods.po.Category;

import java.util.Collections;
import java.util.List;

@Component
public class CategoryApiFallback extends ApiFallback<Category> implements CategoryApi {
    @Override
    public List<Integer> queryIdsByParentId(Integer parentId) {
        return Collections.emptyList();
    }

    @Override
    public List<Integer> queryParentIdsByIdIn(List<Integer> ids) {
        return Collections.emptyList();
    }

    @Override
    public List<Category> queryByIdIn(List<Integer> ids) {
        return Collections.emptyList();
    }
}
