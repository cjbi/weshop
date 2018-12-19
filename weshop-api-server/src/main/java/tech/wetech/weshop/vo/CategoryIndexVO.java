package tech.wetech.weshop.vo;

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

    public void setCategoryList(List<CategoryVO> categoryList) {
        this.categoryList = categoryList;
    }

    public CategoryVO getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(CategoryVO currentCategory) {
        this.currentCategory = currentCategory;
    }
}
