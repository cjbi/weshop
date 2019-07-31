package tech.wetech.weshop.user.po;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "weshop_feedback")
public class Feedback {
    @Id
    @Column(name = "msg_id")
    private Integer msgId;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "msg_title")
    private String msgTitle;

    @Column(name = "msg_type")
    private Boolean msgType;

    @Column(name = "msg_status")
    private Boolean msgStatus;

    @Column(name = "msg_time")
    private Date msgTime;

    @Column(name = "message_img")
    private String messageImg;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "msg_area")
    private Boolean msgArea;

    @Column(name = "msg_content")
    private String msgContent;

    public Integer getMsgId() {
        return msgId;
    }

    public Feedback setMsgId(Integer msgId) {
        this.msgId = msgId;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Feedback setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Feedback setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Feedback setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Feedback setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public Feedback setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
        return this;
    }

    public Boolean getMsgType() {
        return msgType;
    }

    public Feedback setMsgType(Boolean msgType) {
        this.msgType = msgType;
        return this;
    }

    public Boolean getMsgStatus() {
        return msgStatus;
    }

    public Feedback setMsgStatus(Boolean msgStatus) {
        this.msgStatus = msgStatus;
        return this;
    }

    public Date getMsgTime() {
        return msgTime;
    }

    public Feedback setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
        return this;
    }

    public String getMessageImg() {
        return messageImg;
    }

    public Feedback setMessageImg(String messageImg) {
        this.messageImg = messageImg;
        return this;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Feedback setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Boolean getMsgArea() {
        return msgArea;
    }

    public Feedback setMsgArea(Boolean msgArea) {
        this.msgArea = msgArea;
        return this;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public Feedback setMsgContent(String msgContent) {
        this.msgContent = msgContent;
        return this;
    }
}
