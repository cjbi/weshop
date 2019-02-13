package tech.wetech.weshop.user.po;

import javax.persistence.*;

@Table(name = "weshop_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "country_id")
    private Short countryId;

    @Column(name = "province_id")
    private Short provinceId;

    @Column(name = "city_id")
    private Short cityId;

    @Column(name = "district_id")
    private Short districtId;

    private String address;

    private String mobile;

    @Column(name = "is_default")
    private Boolean isDefault;

    public Integer getId() {
        return id;
    }

    public Address setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Address setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Address setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Short getCountryId() {
        return countryId;
    }

    public Address setCountryId(Short countryId) {
        this.countryId = countryId;
        return this;
    }

    public Short getProvinceId() {
        return provinceId;
    }

    public Address setProvinceId(Short provinceId) {
        this.provinceId = provinceId;
        return this;
    }

    public Short getCityId() {
        return cityId;
    }

    public Address setCityId(Short cityId) {
        this.cityId = cityId;
        return this;
    }

    public Short getDistrictId() {
        return districtId;
    }

    public Address setDistrictId(Short districtId) {
        this.districtId = districtId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Address setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Address setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public Address setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }
}