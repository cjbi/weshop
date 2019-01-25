package tech.wetech.weshop.wechat.dto;

import tech.wetech.weshop.po.Address;

public class AddressDTO {

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

    public AddressDTO(Address address) {
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

    public AddressDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AddressDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public AddressDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Short getCountryId() {
        return countryId;
    }

    public AddressDTO setCountryId(Short countryId) {
        this.countryId = countryId;
        return this;
    }

    public Short getProvinceId() {
        return provinceId;
    }

    public AddressDTO setProvinceId(Short provinceId) {
        this.provinceId = provinceId;
        return this;
    }

    public Short getCityId() {
        return cityId;
    }

    public AddressDTO setCityId(Short cityId) {
        this.cityId = cityId;
        return this;
    }

    public Short getDistrictId() {
        return districtId;
    }

    public AddressDTO setDistrictId(Short districtId) {
        this.districtId = districtId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AddressDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public AddressDTO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public AddressDTO setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public AddressDTO setProvinceName(String provinceName) {
        this.provinceName = provinceName;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public AddressDTO setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public String getDistrictName() {
        return districtName;
    }

    public AddressDTO setDistrictName(String districtName) {
        this.districtName = districtName;
        return this;
    }

    public String getFullRegion() {
        return fullRegion;
    }

    public AddressDTO setFullRegion(String fullRegion) {
        this.fullRegion = fullRegion;
        return this;
    }
}
