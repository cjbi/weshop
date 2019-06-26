package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.goods.po.Category;

import java.util.List;

public class GoodsCategoryVO {

    private Category currentCategory;

    private Category parentCategory;

    private List<Category> brotherCategory;

    public GoodsCategoryVO() {
    }

    public GoodsCategoryVO(Category currentCategory, Category parentCategory, List<Category> brotherCategory) {
        this.currentCategory = currentCategory;
        this.parentCategory = parentCategory;
        this.brotherCategory = brotherCategory;
    }

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public GoodsCategoryVO setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
        return this;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public GoodsCategoryVO setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
        return this;
    }

    public List<Category> getBrotherCategory() {
        return brotherCategory;
    }

    public GoodsCategoryVO setBrotherCategory(List<Category> brotherCategory) {
        this.brotherCategory = brotherCategory;
        return this;
    }
}
