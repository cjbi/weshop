package tech.wetech.weshop.mapper;

import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface CategoryMapper extends MyMapper<Category> {

    List<Integer> selectIdsByParentId(Integer parentId);

    List<Integer> selectParentIdsByIdIn(List<Integer> ids);

    List<Category> selectByIdIn(List<Integer> ids);

}