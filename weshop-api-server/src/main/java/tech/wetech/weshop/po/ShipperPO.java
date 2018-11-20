package tech.wetech.weshop.po;

import javax.persistence.*;

@Table(name = "weshop_shipper")
public class ShipperPO {
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
     * 获取快递公司名称
     *
     * @return name - 快递公司名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置快递公司名称
     *
     * @param name 快递公司名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取快递公司代码
     *
     * @return code - 快递公司代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置快递公司代码
     *
     * @param code 快递公司代码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取排序
     *
     * @return sort_order - 排序
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 设置排序
     *
     * @param sortOrder 排序
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}