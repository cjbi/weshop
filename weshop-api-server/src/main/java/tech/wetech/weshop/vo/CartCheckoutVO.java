package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.Address;
import tech.wetech.weshop.po.Coupon;
import tech.wetech.weshop.po.Goods;

import java.math.BigDecimal;
import java.util.List;

public class CartCheckoutVO {

    private BigDecimal actualPrice;

    private CheckedAddressVO checkedAddress;

    private Coupon checkedCoupon;

    private List<Coupon> couponList;

    private List<Goods> checkedGoodsList;

    private BigDecimal couponPrice;

    private BigDecimal freightPrice;

    private BigDecimal goodsTotalPrice;

    private BigDecimal orderTotalPrice;

    public static class CheckedAddressVO {

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

        public CheckedAddressVO(Address address) {
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

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Short getCountryId() {
            return countryId;
        }

        public void setCountryId(Short countryId) {
            this.countryId = countryId;
        }

        public Short getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(Short provinceId) {
            this.provinceId = provinceId;
        }

        public Short getCityId() {
            return cityId;
        }

        public void setCityId(Short cityId) {
            this.cityId = cityId;
        }

        public Short getDistrictId() {
            return districtId;
        }

        public void setDistrictId(Short districtId) {
            this.districtId = districtId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Boolean getDefault() {
            return isDefault;
        }

        public void setDefault(Boolean aDefault) {
            isDefault = aDefault;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getDistrictName() {
            return districtName;
        }

        public void setDistrictName(String districtName) {
            this.districtName = districtName;
        }

        public String getFullRegion() {
            return fullRegion;
        }

        public void setFullRegion(String fullRegion) {
            this.fullRegion = fullRegion;
        }
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public CheckedAddressVO getCheckedAddress() {
        return checkedAddress;
    }

    public void setCheckedAddress(CheckedAddressVO checkedAddress) {
        this.checkedAddress = checkedAddress;
    }

    public Coupon getCheckedCoupon() {
        return checkedCoupon;
    }

    public void setCheckedCoupon(Coupon checkedCoupon) {
        this.checkedCoupon = checkedCoupon;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public List<Goods> getCheckedGoodsList() {
        return checkedGoodsList;
    }

    public void setCheckedGoodsList(List<Goods> checkedGoodsList) {
        this.checkedGoodsList = checkedGoodsList;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }
}
