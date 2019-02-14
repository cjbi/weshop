package tech.wetech.weshop.goods.po;

import tech.wetech.weshop.goods.enums.CategoryLevelEnum;

import javax.persistence.*;

/**
 * @author cjbi@outlook.com
 */
@Table(name = "weshop_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String keywords;

    @Column(name = "front_desc")
    private String frontDesc;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "sort_order")
    private Boolean sortOrder;

    @Column(name = "show_index")
    private Boolean showIndex;

    @Column(name = "is_show")
    private Boolean show;

    @Column(name = "banner_url")
    private String bannerUrl;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "wap_banner_url")
    private String wapBannerUrl;

    @Column(name = "level")
    private CategoryLevelEnum level;

    private Integer type;

    @Column(name = "front_name")
    private String frontName;

    public Integer getId() {
        return id;
    }

    public Category setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public Category setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public String getFrontDesc() {
        return frontDesc;
    }

    public Category setFrontDesc(String frontDesc) {
        this.frontDesc = frontDesc;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Category setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public Boolean getSortOrder() {
        return sortOrder;
    }

    public Category setSortOrder(Boolean sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public Boolean getShowIndex() {
        return showIndex;
    }

    public Category setShowIndex(Boolean showIndex) {
        this.showIndex = showIndex;
        return this;
    }

    public Boolean getShow() {
        return show;
    }

    public Category setShow(Boolean show) {
        this.show = show;
        return this;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public Category setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public Category setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Category setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getWapBannerUrl() {
        return wapBannerUrl;
    }

    public Category setWapBannerUrl(String wapBannerUrl) {
        this.wapBannerUrl = wapBannerUrl;
        return this;
    }

    public CategoryLevelEnum getLevel() {
        return level;
    }

    public Category setLevel(CategoryLevelEnum level) {
        this.level = level;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Category setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getFrontName() {
        return frontName;
    }

    public Category setFrontName(String frontName) {
        this.frontName = frontName;
        return this;
    }
}