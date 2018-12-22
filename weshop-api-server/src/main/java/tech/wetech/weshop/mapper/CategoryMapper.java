package tech.wetech.weshop.mapper;

import org.apache.ibatis.annotations.Param;
import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface CategoryMapper extends MyMapper<Category> {

    List<Integer> selectIdsByParentId(Integer parentId);

    List<Integer> selectParentIdsByIn(@Param("ids") List<Integer> ids);

}