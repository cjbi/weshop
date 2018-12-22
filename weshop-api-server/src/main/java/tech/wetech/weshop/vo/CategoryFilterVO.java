package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.Category;

public class CategoryFilterVO {

    private Integer id;

    private String name;

    private Boolean checked;

    public CategoryFilterVO(Integer id, String name, Boolean checked) {
        this.id = id;
        this.name = name;
        this.checked = checked;
    }

    public CategoryFilterVO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.checked = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getChecked() {
        return checked;
    }

    public CategoryFilterVO setChecked(Boolean checked) {
        this.checked = checked;
        return this;
    }
}
