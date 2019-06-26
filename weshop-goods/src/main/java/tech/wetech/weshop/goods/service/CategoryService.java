package tech.wetech.weshop.goods.service;

import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.goods.po.Category;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface CategoryService extends IService<Category> {

    List<Integer> queryIdsByParentId(Integer parentId);

    List<Integer> queryParentIdsByIdIn(List<Integer> ids);

    List<Category> queryByIdIn(List<Integer> ids);
}
