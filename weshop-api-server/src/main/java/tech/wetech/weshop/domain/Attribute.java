package tech.wetech.weshop.domain;

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

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return attribute_category_id
     */
    public Integer getAttributeCategoryId() {
        return attributeCategoryId;
    }

    /**
     * @param attributeCategoryId
     */
    public void setAttributeCategoryId(Integer attributeCategoryId) {
        this.attributeCategoryId = attributeCategoryId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return input_type
     */
    public Boolean getInputType() {
        return inputType;
    }

    /**
     * @param inputType
     */
    public void setInputType(Boolean inputType) {
        this.inputType = inputType;
    }

    /**
     * @return sort_order
     */
    public Byte getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder
     */
    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * @return values
     */
    public String getValues() {
        return values;
    }

    /**
     * @param values
     */
    public void setValues(String values) {
        this.values = values;
    }
}