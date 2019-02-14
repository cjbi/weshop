package tech.wetech.weshop.goods.dto;

import java.util.List;

public class CategoryIndexDTO {

    private List<CategoryDTO> categoryList;

    private CategoryDTO currentCategory;

    public CategoryIndexDTO() {
    }

    public CategoryIndexDTO(List<CategoryDTO> categoryList, CategoryDTO currentCategory) {
        this.categoryList = categoryList;
        this.currentCategory = currentCategory;
    }

    public List<CategoryDTO> getCategoryList() {
        return categoryList;
    }

    public CategoryIndexDTO setCategoryList(List<CategoryDTO> categoryList) {
        this.categoryList = categoryList;
        return this;
    }

    public CategoryDTO getCurrentCategory() {
        return currentCategory;
    }

    public CategoryIndexDTO setCurrentCategory(CategoryDTO currentCategory) {
        this.currentCategory = currentCategory;
        return this;
    }
}
