package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.goods.fallback.CategoryApiFallback;
import tech.wetech.weshop.goods.po.Category;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@FeignClient(value = "weshop-goods", path = "category", fallback = CategoryApiFallback.class)
public interface CategoryApi extends Api<Category> {

    @GetMapping("/queryIdsByParentId")
    Result<List<Integer>> queryIdsByParentId(@RequestBody Integer parentId);

    @GetMapping("/queryParentIdsByIdIn")
    Result<List<Integer>> queryParentIdsByIdIn(@RequestBody List<Integer> ids);

    @GetMapping("/queryByIdIn")
    Result<List<Category>> queryByIdIn(@RequestBody List<Integer> ids);

}
