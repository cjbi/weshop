package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.Category;

import java.util.List;

public class GoodsCategoryVO {

    private Category currentCategory;

    private Category parentCategory;

    private List<Category> brotherCategory;

    public GoodsCategoryVO(Category currentCategory, Category parentCategory, List<Category> brotherCategory) {
        this.currentCategory = currentCategory;
        this.parentCategory = parentCategory;
        this.brotherCategory = brotherCategory;
    }

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Category> getBrotherCategory() {
        return brotherCategory;
    }

    public void setBrotherCategory(List<Category> brotherCategory) {
        this.brotherCategory = brotherCategory;
    }
}
