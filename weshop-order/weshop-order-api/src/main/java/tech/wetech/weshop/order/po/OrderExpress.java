package tech.wetech.weshop.order.po;

import javax.persistence.*;
import java.util.Date;

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
    private Boolean finish;

    /**
     * 总查询次数
     */
    @Column(name = "request_count")
    private Integer requestCount;

    /**
     * 最近一次向第三方查询物流信息时间
     */
    @Column(name = "request_time")
    private Date requestTime;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public OrderExpress setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public OrderExpress setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public OrderExpress setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
        return this;
    }

    public String getShipperName() {
        return shipperName;
    }

    public OrderExpress setShipperName(String shipperName) {
        this.shipperName = shipperName;
        return this;
    }

    public String getShipperCode() {
        return shipperCode;
    }

    public OrderExpress setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
        return this;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public OrderExpress setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
        return this;
    }

    public String getTraces() {
        return traces;
    }

    public OrderExpress setTraces(String traces) {
        this.traces = traces;
        return this;
    }

    public Boolean getFinish() {
        return finish;
    }

    public OrderExpress setFinish(Boolean finish) {
        this.finish = finish;
        return this;
    }

    public Integer getRequestCount() {
        return requestCount;
    }

    public OrderExpress setRequestCount(Integer requestCount) {
        this.requestCount = requestCount;
        return this;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public OrderExpress setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public OrderExpress setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public OrderExpress setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}