package tech.wetech.weshop.po;

import tech.wetech.weshop.enums.RegionTypeEnum;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;

@Table(name = "weshop_region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "parent_id")
    private Short parentId;

    private String name;

    @ColumnType
    private RegionTypeEnum type;

    @Column(name = "agency_id")
    private Short agencyId;

    /**
     * @return id
     */
    public Short getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * @return parent_id
     */
    public Short getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Short parentId) {
        this.parentId = parentId;
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
     * @return type
     */
    public RegionTypeEnum getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(RegionTypeEnum type) {
        this.type = type;
    }

    /**
     * @return agency_id
     */
    public Short getAgencyId() {
        return agencyId;
    }

    /**
     * @param agencyId
     */
    public void setAgencyId(Short agencyId) {
        this.agencyId = agencyId;
    }
}