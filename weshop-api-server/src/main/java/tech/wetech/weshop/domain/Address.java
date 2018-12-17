package tech.wetech.weshop.domain;

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
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return country_id
     */
    public Short getCountryId() {
        return countryId;
    }

    /**
     * @param countryId
     */
    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    /**
     * @return province_id
     */
    public Short getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId
     */
    public void setProvinceId(Short provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * @return city_id
     */
    public Short getCityId() {
        return cityId;
    }

    /**
     * @param cityId
     */
    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    /**
     * @return district_id
     */
    public Short getDistrictId() {
        return districtId;
    }

    /**
     * @param districtId
     */
    public void setDistrictId(Short districtId) {
        this.districtId = districtId;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return is_default
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}