package tech.wetech.weshop.modules.app.po;

import java.math.BigDecimal;
import javax.persistence.*;

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
     * @return type_money
     */
    public BigDecimal getTypeMoney() {
        return typeMoney;
    }

    /**
     * @param typeMoney
     */
    public void setTypeMoney(BigDecimal typeMoney) {
        this.typeMoney = typeMoney;
    }

    /**
     * @return send_type
     */
    public Byte getSendType() {
        return sendType;
    }

    /**
     * @param sendType
     */
    public void setSendType(Byte sendType) {
        this.sendType = sendType;
    }

    /**
     * @return min_amount
     */
    public BigDecimal getMinAmount() {
        return minAmount;
    }

    /**
     * @param minAmount
     */
    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    /**
     * @return max_amount
     */
    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    /**
     * @param maxAmount
     */
    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * @return send_start_date
     */
    public Integer getSendStartDate() {
        return sendStartDate;
    }

    /**
     * @param sendStartDate
     */
    public void setSendStartDate(Integer sendStartDate) {
        this.sendStartDate = sendStartDate;
    }

    /**
     * @return send_end_date
     */
    public Integer getSendEndDate() {
        return sendEndDate;
    }

    /**
     * @param sendEndDate
     */
    public void setSendEndDate(Integer sendEndDate) {
        this.sendEndDate = sendEndDate;
    }

    /**
     * @return use_start_date
     */
    public Integer getUseStartDate() {
        return useStartDate;
    }

    /**
     * @param useStartDate
     */
    public void setUseStartDate(Integer useStartDate) {
        this.useStartDate = useStartDate;
    }

    /**
     * @return use_end_date
     */
    public Integer getUseEndDate() {
        return useEndDate;
    }

    /**
     * @param useEndDate
     */
    public void setUseEndDate(Integer useEndDate) {
        this.useEndDate = useEndDate;
    }

    /**
     * @return min_goods_amount
     */
    public BigDecimal getMinGoodsAmount() {
        return minGoodsAmount;
    }

    /**
     * @param minGoodsAmount
     */
    public void setMinGoodsAmount(BigDecimal minGoodsAmount) {
        this.minGoodsAmount = minGoodsAmount;
    }
}