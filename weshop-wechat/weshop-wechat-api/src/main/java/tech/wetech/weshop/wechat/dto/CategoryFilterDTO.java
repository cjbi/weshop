package tech.wetech.weshop.wechat.dto;

import tech.wetech.weshop.po.Category;

public class CategoryFilterDTO {

    private Integer id;

    private String name;

    private Boolean checked;

    public CategoryFilterDTO(Integer id, String name, Boolean checked) {
        this.id = id;
        this.name = name;
        this.checked = checked;
    }

    public CategoryFilterDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.checked = false;
    }

    public Integer getId() {
        return id;
    }

    public CategoryFilterDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryFilterDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getChecked() {
        return checked;
    }

    public CategoryFilterDTO setChecked(Boolean checked) {
        this.checked = checked;
        return this;
    }
}
