package tech.wetech.weshop.domain;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "weshop_topic")
public class Topic {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String avatar;

    @Column(name = "item_pic_url")
    private String itemPicUrl;

    private String subtitle;

    @Column(name = "topic_category_id")
    private Integer topicCategoryId;

    @Column(name = "price_info")
    private BigDecimal priceInfo;

    @Column(name = "read_count")
    private String readCount;

    @Column(name = "scene_pic_url")
    private String scenePicUrl;

    @Column(name = "topic_template_id")
    private Integer topicTemplateId;

    @Column(name = "topic_tag_id")
    private Integer topicTagId;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "is_show")
    private Boolean isShow;

    private String content;

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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return item_pic_url
     */
    public String getItemPicUrl() {
        return itemPicUrl;
    }

    /**
     * @param itemPicUrl
     */
    public void setItemPicUrl(String itemPicUrl) {
        this.itemPicUrl = itemPicUrl;
    }

    /**
     * @return subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * @param subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * @return topic_category_id
     */
    public Integer getTopicCategoryId() {
        return topicCategoryId;
    }

    /**
     * @param topicCategoryId
     */
    public void setTopicCategoryId(Integer topicCategoryId) {
        this.topicCategoryId = topicCategoryId;
    }

    /**
     * @return price_info
     */
    public BigDecimal getPriceInfo() {
        return priceInfo;
    }

    /**
     * @param priceInfo
     */
    public void setPriceInfo(BigDecimal priceInfo) {
        this.priceInfo = priceInfo;
    }

    /**
     * @return read_count
     */
    public String getReadCount() {
        return readCount;
    }

    /**
     * @param readCount
     */
    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    /**
     * @return scene_pic_url
     */
    public String getScenePicUrl() {
        return scenePicUrl;
    }

    /**
     * @param scenePicUrl
     */
    public void setScenePicUrl(String scenePicUrl) {
        this.scenePicUrl = scenePicUrl;
    }

    /**
     * @return topic_template_id
     */
    public Integer getTopicTemplateId() {
        return topicTemplateId;
    }

    /**
     * @param topicTemplateId
     */
    public void setTopicTemplateId(Integer topicTemplateId) {
        this.topicTemplateId = topicTemplateId;
    }

    /**
     * @return topic_tag_id
     */
    public Integer getTopicTagId() {
        return topicTagId;
    }

    /**
     * @param topicTagId
     */
    public void setTopicTagId(Integer topicTagId) {
        this.topicTagId = topicTagId;
    }

    /**
     * @return sort_order
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * @return is_show
     */
    public Boolean getIsShow() {
        return isShow;
    }

    /**
     * @param isShow
     */
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}