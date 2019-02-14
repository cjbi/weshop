package tech.wetech.weshop.user.po;

import tech.wetech.weshop.user.enums.RegionTypeEnum;

import javax.persistence.*;

@Table(name = "weshop_region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "parent_id")
    private Short parentId;

    private String name;

    @Column(name = "type")
    private RegionTypeEnum type;

    @Column(name = "agency_id")
    private Short agencyId;

    public Short getId() {
        return id;
    }

    public Region setId(Short id) {
        this.id = id;
        return this;
    }

    public Short getParentId() {
        return parentId;
    }

    public Region setParentId(Short parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Region setName(String name) {
        this.name = name;
        return this;
    }

    public RegionTypeEnum getType() {
        return type;
    }

    public Region setType(RegionTypeEnum type) {
        this.type = type;
        return this;
    }

    public Short getAgencyId() {
        return agencyId;
    }

    public Region setAgencyId(Short agencyId) {
        this.agencyId = agencyId;
        return this;
    }
}