package tech.wetech.weshop.goods.po;

import javax.persistence.*;

@Table(name = "weshop_attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "attribute_category_id")
    private Integer attributeCategoryId;

    private String name;

    @Column(name = "input_type")
    private Boolean inputType;

    @Column(name = "sort_order")
    private Byte sortOrder;

    private String values;

    public Integer getId() {
        return id;
    }

    public Attribute setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getAttributeCategoryId() {
        return attributeCategoryId;
    }

    public Attribute setAttributeCategoryId(Integer attributeCategoryId) {
        this.attributeCategoryId = attributeCategoryId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Attribute setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getInputType() {
        return inputType;
    }

    public Attribute setInputType(Boolean inputType) {
        this.inputType = inputType;
        return this;
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public Attribute setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public String getValues() {
        return values;
    }

    public Attribute setValues(String values) {
        this.values = values;
        return this;
    }
}