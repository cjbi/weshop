package tech.wetech.weshop.goods.po;

import javax.persistence.*;

@Table(name = "weshop_specification")
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "sort_order")
    private Byte sortOrder;

    public Integer getId() {
        return id;
    }

    public Specification setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Specification setName(String name) {
        this.name = name;
        return this;
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public Specification setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }
}