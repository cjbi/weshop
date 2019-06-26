package tech.wetech.weshop.wechat.vo;

import java.util.List;

public class CategoryIndexVO {

    private List<CategoryVO> categoryList;

    private CategoryVO currentCategory;

    public CategoryIndexVO() {
    }

    public CategoryIndexVO(List<CategoryVO> categoryList, CategoryVO currentCategory) {
        this.categoryList = categoryList;
        this.currentCategory = currentCategory;
    }

    public List<CategoryVO> getCategoryList() {
        return categoryList;
    }

    public CategoryIndexVO setCategoryList(List<CategoryVO> categoryList) {
        this.categoryList = categoryList;
        return this;
    }

    public CategoryVO getCurrentCategory() {
        return currentCategory;
    }

    public CategoryIndexVO setCurrentCategory(CategoryVO currentCategory) {
        this.currentCategory = currentCategory;
        return this;
    }
}
