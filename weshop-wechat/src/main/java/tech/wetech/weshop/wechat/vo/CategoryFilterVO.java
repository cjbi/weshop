package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.goods.po.Category;

public class CategoryFilterVO {

    private Integer id;

    private String name;

    private Boolean checked;

    public CategoryFilterVO() {
    }

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

    public CategoryFilterVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryFilterVO setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getChecked() {
        return checked;
    }

    public CategoryFilterVO setChecked(Boolean checked) {
        this.checked = checked;
        return this;
    }
}
