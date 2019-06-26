package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.order.po.Cart;
import tech.wetech.weshop.user.po.Address;
import tech.wetech.weshop.user.po.UserCoupon;

import java.math.BigDecimal;
import java.util.List;

public class CartCheckoutVO {

    private BigDecimal actualPrice;

    private CheckedAddressVO checkedAddress;

    private UserCoupon checkedCoupon;

    private List<UserCoupon> couponList;

    private List<Cart> checkedGoodsList;

    private BigDecimal couponPrice;

    private BigDecimal freightPrice;

    private BigDecimal goodsTotalPrice;

    private BigDecimal orderTotalPrice;

    public CartCheckoutVO() {
    }

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

        public CheckedAddressVO() {
        }

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

        public CheckedAddressVO setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public CheckedAddressVO setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getUserId() {
            return userId;
        }

        public CheckedAddressVO setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Short getCountryId() {
            return countryId;
        }

        public CheckedAddressVO setCountryId(Short countryId) {
            this.countryId = countryId;
            return this;
        }

        public Short getProvinceId() {
            return provinceId;
        }

        public CheckedAddressVO setProvinceId(Short provinceId) {
            this.provinceId = provinceId;
            return this;
        }

        public Short getCityId() {
            return cityId;
        }

        public CheckedAddressVO setCityId(Short cityId) {
            this.cityId = cityId;
            return this;
        }

        public Short getDistrictId() {
            return districtId;
        }

        public CheckedAddressVO setDistrictId(Short districtId) {
            this.districtId = districtId;
            return this;
        }

        public String getAddress() {
            return address;
        }

        public CheckedAddressVO setAddress(String address) {
            this.address = address;
            return this;
        }

        public String getMobile() {
            return mobile;
        }

        public CheckedAddressVO setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Boolean getIsDefault() {
            return isDefault;
        }

        public CheckedAddressVO setIsDefault(Boolean isDefault) {
            this.isDefault = isDefault;
            return this;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public CheckedAddressVO setProvinceName(String provinceName) {
            this.provinceName = provinceName;
            return this;
        }

        public String getCityName() {
            return cityName;
        }

        public CheckedAddressVO setCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public String getDistrictName() {
            return districtName;
        }

        public CheckedAddressVO setDistrictName(String districtName) {
            this.districtName = districtName;
            return this;
        }

        public String getFullRegion() {
            return fullRegion;
        }

        public CheckedAddressVO setFullRegion(String fullRegion) {
            this.fullRegion = fullRegion;
            return this;
        }
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public CartCheckoutVO setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
        return this;
    }

    public CheckedAddressVO getCheckedAddress() {
        return checkedAddress;
    }

    public CartCheckoutVO setCheckedAddress(CheckedAddressVO checkedAddress) {
        this.checkedAddress = checkedAddress;
        return this;
    }

    public UserCoupon getCheckedCoupon() {
        return checkedCoupon;
    }

    public CartCheckoutVO setCheckedCoupon(UserCoupon checkedCoupon) {
        this.checkedCoupon = checkedCoupon;
        return this;
    }

    public List<UserCoupon> getCouponList() {
        return couponList;
    }

    public CartCheckoutVO setCouponList(List<UserCoupon> couponList) {
        this.couponList = couponList;
        return this;
    }

    public List<Cart> getCheckedGoodsList() {
        return checkedGoodsList;
    }

    public CartCheckoutVO setCheckedGoodsList(List<Cart> checkedGoodsList) {
        this.checkedGoodsList = checkedGoodsList;
        return this;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public CartCheckoutVO setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
        return this;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public CartCheckoutVO setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
        return this;
    }

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public CartCheckoutVO setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
        return this;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public CartCheckoutVO setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
        return this;
    }
}
