package tech.wetech.weshop.user.po;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "weshop_coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    private String name;

    @Column(name = "type_money")
    private BigDecimal typeMoney;

    @Column(name = "send_type")
    private Byte sendType;

    @Column(name = "min_amount")
    private BigDecimal minAmount;

    @Column(name = "max_amount")
    private BigDecimal maxAmount;

    @Column(name = "send_start_date")
    private Integer sendStartDate;

    @Column(name = "send_end_date")
    private Integer sendEndDate;

    @Column(name = "use_start_date")
    private Integer useStartDate;

    @Column(name = "use_end_date")
    private Integer useEndDate;

    @Column(name = "min_goods_amount")
    private BigDecimal minGoodsAmount;

    public Short getId() {
        return id;
    }

    public Coupon setId(Short id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Coupon setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getTypeMoney() {
        return typeMoney;
    }

    public Coupon setTypeMoney(BigDecimal typeMoney) {
        this.typeMoney = typeMoney;
        return this;
    }

    public Byte getSendType() {
        return sendType;
    }

    public Coupon setSendType(Byte sendType) {
        this.sendType = sendType;
        return this;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public Coupon setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
        return this;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public Coupon setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
        return this;
    }

    public Integer getSendStartDate() {
        return sendStartDate;
    }

    public Coupon setSendStartDate(Integer sendStartDate) {
        this.sendStartDate = sendStartDate;
        return this;
    }

    public Integer getSendEndDate() {
        return sendEndDate;
    }

    public Coupon setSendEndDate(Integer sendEndDate) {
        this.sendEndDate = sendEndDate;
        return this;
    }

    public Integer getUseStartDate() {
        return useStartDate;
    }

    public Coupon setUseStartDate(Integer useStartDate) {
        this.useStartDate = useStartDate;
        return this;
    }

    public Integer getUseEndDate() {
        return useEndDate;
    }

    public Coupon setUseEndDate(Integer useEndDate) {
        this.useEndDate = useEndDate;
        return this;
    }

    public BigDecimal getMinGoodsAmount() {
        return minGoodsAmount;
    }

    public Coupon setMinGoodsAmount(BigDecimal minGoodsAmount) {
        this.minGoodsAmount = minGoodsAmount;
        return this;
    }
}