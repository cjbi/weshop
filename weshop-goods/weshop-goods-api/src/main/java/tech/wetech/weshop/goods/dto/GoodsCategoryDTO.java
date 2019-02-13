package tech.wetech.weshop.goods.dto;

import tech.wetech.weshop.goods.po.Category;

import java.util.List;

public class GoodsCategoryDTO {

    private Category currentCategory;

    private Category parentCategory;

    private List<Category> brotherCategory;

    public GoodsCategoryDTO(Category currentCategory, Category parentCategory, List<Category> brotherCategory) {
        this.currentCategory = currentCategory;
        this.parentCategory = parentCategory;
        this.brotherCategory = brotherCategory;
    }

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public GoodsCategoryDTO setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
        return this;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public GoodsCategoryDTO setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
        return this;
    }

    public List<Category> getBrotherCategory() {
        return brotherCategory;
    }

    public GoodsCategoryDTO setBrotherCategory(List<Category> brotherCategory) {
        this.brotherCategory = brotherCategory;
        return this;
    }
}
