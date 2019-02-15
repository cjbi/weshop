package tech.wetech.weshop.order.po;

import javax.persistence.*;

@Table(name = "weshop_shipper")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 快递公司名称
     */
    private String name;

    /**
     * 快递公司代码
     */
    private String code;

    /**
     * 排序
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    public Integer getId() {
        return id;
    }

    public Shipper setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Shipper setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Shipper setCode(String code) {
        this.code = code;
        return this;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public Shipper setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }
}