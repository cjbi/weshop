package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.user.po.Address;

public class AddressVO {

    private Integer id;

    private String name;

    private Integer userId;

    private Short countryId;

    private Short provinceId;

    private Short cityId;

    private Short districtId;

    private String address;

    private String mobile;

    private Boolean isDefault;

    private String provinceName;

    private String cityName;

    private String districtName;

    private String fullRegion;

    public AddressVO() {
    }

    public AddressVO(Address address) {
        this.id = address.getId();
        this.name = address.getName();
        this.userId = address.getUserId();
        this.countryId = address.getCountryId();
        this.provinceId = address.getProvinceId();
        this.cityId = address.getCityId();
        this.districtId = address.getDistrictId();
        this.address = address.getAddress();
        this.mobile = address.getMobile();
        this.isDefault = address.getIsDefault();
        this.provinceName = null;
        this.cityName = null;
        this.districtName = null;
        this.fullRegion = null;
    }

    public Integer getId() {
        return id;
    }

    public AddressVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AddressVO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public AddressVO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Short getCountryId() {
        return countryId;
    }

    public AddressVO setCountryId(Short countryId) {
        this.countryId = countryId;
        return this;
    }

    public Short getProvinceId() {
        return provinceId;
    }

    public AddressVO setProvinceId(Short provinceId) {
        this.provinceId = provinceId;
        return this;
    }

    public Short getCityId() {
        return cityId;
    }

    public AddressVO setCityId(Short cityId) {
        this.cityId = cityId;
        return this;
    }

    public Short getDistrictId() {
        return districtId;
    }

    public AddressVO setDistrictId(Short districtId) {
        this.districtId = districtId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AddressVO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public AddressVO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public AddressVO setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public AddressVO setProvinceName(String provinceName) {
        this.provinceName = provinceName;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public AddressVO setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getDistrictName() {
        return districtName;
    }

    public AddressVO setDistrictName(String districtName) {
        this.districtName = districtName;
        return this;
    }

    public String getFullRegion() {
        return fullRegion;
    }

    public AddressVO setFullRegion(String fullRegion) {
        this.fullRegion = fullRegion;
        return this;
    }
}
