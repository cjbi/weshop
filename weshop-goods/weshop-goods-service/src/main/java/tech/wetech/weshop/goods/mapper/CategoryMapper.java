package tech.wetech.weshop.goods.mapper;

import tech.wetech.weshop.goods.po.Category;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface CategoryMapper extends MyMapper<Category> {

    List<Integer> selectIdsByParentId(Integer parentId);

    List<Integer> selectParentIdsByIdIn(List<Integer> ids);

    List<Category> selectByIdIn(List<Integer> ids);

}