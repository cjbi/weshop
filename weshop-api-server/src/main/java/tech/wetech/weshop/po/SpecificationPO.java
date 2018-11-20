package tech.wetech.weshop.po;

import javax.persistence.*;

@Table(name = "weshop_specification")
public class SpecificationPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "sort_order")
    private Byte sortOrder;

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
}