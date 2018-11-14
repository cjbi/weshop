package tech.wetech.weshop.modules.app.po;

import javax.persistence.*;

@Table(name = "weshop_order_express")
public class OrderExpress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "shipper_id")
    private Integer shipperId;

    /**
     * 物流公司名称
     */
    @Column(name = "shipper_name")
    private String shipperName;

    /**
     * 物流公司代码
     */
    @Column(name = "shipper_code")
    private String shipperCode;

    /**
     * 快递单号
     */
    @Column(name = "logistic_code")
    private String logisticCode;

    /**
     * 物流跟踪信息
     */
    private String traces;

    @Column(name = "is_finish")
    private Boolean isFinish;

    /**
     * 总查询次数
     */
    @Column(name = "request_count")
    private Integer requestCount;

    /**
     * 最近一次向第三方查询物流信息时间
     */
    @Column(name = "request_time")
    private Integer requestTime;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Integer addTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Integer updateTime;

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
     * @return order_id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return shipper_id
     */
    public Integer getShipperId() {
        return shipperId;
    }

    /**
     * @param shipperId
     */
    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    /**
     * 获取物流公司名称
     *
     * @return shipper_name - 物流公司名称
     */
    public String getShipperName() {
        return shipperName;
    }

    /**
     * 设置物流公司名称
     *
     * @param shipperName 物流公司名称
     */
    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    /**
     * 获取物流公司代码
     *
     * @return shipper_code - 物流公司代码
     */
    public String getShipperCode() {
        return shipperCode;
    }

    /**
     * 设置物流公司代码
     *
     * @param shipperCode 物流公司代码
     */
    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    /**
     * 获取快递单号
     *
     * @return logistic_code - 快递单号
     */
    public String getLogisticCode() {
        return logisticCode;
    }

    /**
     * 设置快递单号
     *
     * @param logisticCode 快递单号
     */
    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    /**
     * 获取物流跟踪信息
     *
     * @return traces - 物流跟踪信息
     */
    public String getTraces() {
        return traces;
    }

    /**
     * 设置物流跟踪信息
     *
     * @param traces 物流跟踪信息
     */
    public void setTraces(String traces) {
        this.traces = traces;
    }

    /**
     * @return is_finish
     */
    public Boolean getIsFinish() {
        return isFinish;
    }

    /**
     * @param isFinish
     */
    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }

    /**
     * 获取总查询次数
     *
     * @return request_count - 总查询次数
     */
    public Integer getRequestCount() {
        return requestCount;
    }

    /**
     * 设置总查询次数
     *
     * @param requestCount 总查询次数
     */
    public void setRequestCount(Integer requestCount) {
        this.requestCount = requestCount;
    }

    /**
     * 获取最近一次向第三方查询物流信息时间
     *
     * @return request_time - 最近一次向第三方查询物流信息时间
     */
    public Integer getRequestTime() {
        return requestTime;
    }

    /**
     * 设置最近一次向第三方查询物流信息时间
     *
     * @param requestTime 最近一次向第三方查询物流信息时间
     */
    public void setRequestTime(Integer requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public Integer getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Integer getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }
}