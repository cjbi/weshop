package tech.wetech.weshop.po;

import javax.persistence.*;

@Table(name = "weshop_attribute_category")
public class AttributeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public AttributeCategory setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AttributeCategory setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public AttributeCategory setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}