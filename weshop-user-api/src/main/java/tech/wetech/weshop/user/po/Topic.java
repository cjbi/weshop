package tech.wetech.weshop.user.po;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "weshop_topic")
public class Topic implements Serializable {
    @Id
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
    private Boolean show;

    private String content;

    public Integer getId() {
        return id;
    }

    public Topic setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Topic setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public Topic setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getItemPicUrl() {
        return itemPicUrl;
    }

    public Topic setItemPicUrl(String itemPicUrl) {
        this.itemPicUrl = itemPicUrl;
        return this;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Topic setSubtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public Integer getTopicCategoryId() {
        return topicCategoryId;
    }

    public Topic setTopicCategoryId(Integer topicCategoryId) {
        this.topicCategoryId = topicCategoryId;
        return this;
    }

    public BigDecimal getPriceInfo() {
        return priceInfo;
    }

    public Topic setPriceInfo(BigDecimal priceInfo) {
        this.priceInfo = priceInfo;
        return this;
    }

    public String getReadCount() {
        return readCount;
    }

    public Topic setReadCount(String readCount) {
        this.readCount = readCount;
        return this;
    }

    public String getScenePicUrl() {
        return scenePicUrl;
    }

    public Topic setScenePicUrl(String scenePicUrl) {
        this.scenePicUrl = scenePicUrl;
        return this;
    }

    public Integer getTopicTemplateId() {
        return topicTemplateId;
    }

    public Topic setTopicTemplateId(Integer topicTemplateId) {
        this.topicTemplateId = topicTemplateId;
        return this;
    }

    public Integer getTopicTagId() {
        return topicTagId;
    }

    public Topic setTopicTagId(Integer topicTagId) {
        this.topicTagId = topicTagId;
        return this;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public Topic setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public Boolean getShow() {
        return show;
    }

    public Topic setShow(Boolean show) {
        this.show = show;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Topic setContent(String content) {
        this.content = content;
        return this;
    }
}
