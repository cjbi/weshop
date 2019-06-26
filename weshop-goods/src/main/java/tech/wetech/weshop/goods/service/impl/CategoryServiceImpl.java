package tech.wetech.weshop.goods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.service.BaseService;
import tech.wetech.weshop.goods.mapper.CategoryMapper;
import tech.wetech.weshop.goods.po.Category;
import tech.wetech.weshop.goods.service.CategoryService;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@Service
public class CategoryServiceImpl extends BaseService<Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Integer> queryIdsByParentId(Integer parentId) {
        return categoryMapper.selectIdsByParentId(parentId);
    }

    @Override
    public List<Integer> queryParentIdsByIdIn(List<Integer> ids) {
        return categoryMapper.selectParentIdsByIdIn(ids);
    }

    @Override
    public List<Category> queryByIdIn(List<Integer> ids) {
        return categoryMapper.selectByIdIn(ids);
    }
}
