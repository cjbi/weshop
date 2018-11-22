package tech.wetech.weshop.vo;

import tech.wetech.weshop.enums.CategoryLevelEnum;

/**
 * @author cjbi
 */
public class UpdateCategoryFormVO {

    private String name;

    private String keywords;

    private String frontDesc;

    private Integer parentId;

    private Boolean sortOrder;

    private Boolean showIndex;

    private Boolean isShow;

    private String bannerUrl;

    private String iconUrl;

    private String imgUrl;

    private String wapBannerUrl;

    private CategoryLevelEnum level;

    private Integer type;

    private String frontName;

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
     * @return keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return front_desc
     */
    public String getFrontDesc() {
        return frontDesc;
    }

    /**
     * @param frontDesc
     */
    public void setFrontDesc(String frontDesc) {
        this.frontDesc = frontDesc;
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
     * @return sort_order
     */
    public Boolean getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder
     */
    public void setSortOrder(Boolean sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * @return show_index
     */
    public Boolean getShowIndex() {
        return showIndex;
    }

    /**
     * @param showIndex
     */
    public void setShowIndex(Boolean showIndex) {
        this.showIndex = showIndex;
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
     * @return banner_url
     */
    public String getBannerUrl() {
        return bannerUrl;
    }

    /**
     * @param bannerUrl
     */
    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    /**
     * @return icon_url
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * @param iconUrl
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * @return img_url
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * @return wap_banner_url
     */
    public String getWapBannerUrl() {
        return wapBannerUrl;
    }

    /**
     * @param wapBannerUrl
     */
    public void setWapBannerUrl(String wapBannerUrl) {
        this.wapBannerUrl = wapBannerUrl;
    }

    /**
     * @return level
     */
    public CategoryLevelEnum getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(CategoryLevelEnum level) {
        this.level = level;
    }

    /**
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return front_name
     */
    public String getFrontName() {
        return frontName;
    }

    /**
     * @param frontName
     */
    public void setFrontName(String frontName) {
        this.frontName = frontName;
    }
}