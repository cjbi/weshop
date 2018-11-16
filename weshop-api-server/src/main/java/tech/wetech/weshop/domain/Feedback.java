package tech.wetech.weshop.domain;

import javax.persistence.*;

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
    private Integer msgTime;

    @Column(name = "message_img")
    private String messageImg;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "msg_area")
    private Boolean msgArea;

    @Column(name = "msg_content")
    private String msgContent;

    /**
     * @return msg_id
     */
    public Integer getMsgId() {
        return msgId;
    }

    /**
     * @param msgId
     */
    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return msg_title
     */
    public String getMsgTitle() {
        return msgTitle;
    }

    /**
     * @param msgTitle
     */
    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    /**
     * @return msg_type
     */
    public Boolean getMsgType() {
        return msgType;
    }

    /**
     * @param msgType
     */
    public void setMsgType(Boolean msgType) {
        this.msgType = msgType;
    }

    /**
     * @return msg_status
     */
    public Boolean getMsgStatus() {
        return msgStatus;
    }

    /**
     * @param msgStatus
     */
    public void setMsgStatus(Boolean msgStatus) {
        this.msgStatus = msgStatus;
    }

    /**
     * @return msg_time
     */
    public Integer getMsgTime() {
        return msgTime;
    }

    /**
     * @param msgTime
     */
    public void setMsgTime(Integer msgTime) {
        this.msgTime = msgTime;
    }

    /**
     * @return message_img
     */
    public String getMessageImg() {
        return messageImg;
    }

    /**
     * @param messageImg
     */
    public void setMessageImg(String messageImg) {
        this.messageImg = messageImg;
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
     * @return msg_area
     */
    public Boolean getMsgArea() {
        return msgArea;
    }

    /**
     * @param msgArea
     */
    public void setMsgArea(Boolean msgArea) {
        this.msgArea = msgArea;
    }

    /**
     * @return msg_content
     */
    public String getMsgContent() {
        return msgContent;
    }

    /**
     * @param msgContent
     */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }
}