package tech.wetech.weshop.vo;

import tech.wetech.weshop.po.Category;
import tech.wetech.weshop.enums.CategoryLevelEnum;

import java.util.List;

public class CategoryVO {

    private Integer id;

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

    private List<Category> subCategoryList;

    public CategoryVO() {
    }

    public CategoryVO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.keywords = category.getKeywords();
        this.frontDesc = category.getFrontDesc();
        this.parentId = category.getParentId();
        this.sortOrder = category.getSortOrder();
        this.showIndex = category.getShowIndex();
        this.isShow = category.getIsShow();
        this.bannerUrl = category.getBannerUrl();
        this.iconUrl = category.getIconUrl();
        this.imgUrl = category.getImgUrl();
        this.wapBannerUrl = category.getWapBannerUrl();
        this.level = category.getLevel();
        this.type = category.getType();
        this.frontName = category.getFrontName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getFrontDesc() {
        return frontDesc;
    }

    public void setFrontDesc(String frontDesc) {
        this.frontDesc = frontDesc;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Boolean sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getShowIndex() {
        return showIndex;
    }

    public void setShowIndex(Boolean showIndex) {
        this.showIndex = showIndex;
    }

    public Boolean getShow() {
        return isShow;
    }

    public void setShow(Boolean show) {
        isShow = show;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getWapBannerUrl() {
        return wapBannerUrl;
    }

    public void setWapBannerUrl(String wapBannerUrl) {
        this.wapBannerUrl = wapBannerUrl;
    }

    public CategoryLevelEnum getLevel() {
        return level;
    }

    public void setLevel(CategoryLevelEnum level) {
        this.level = level;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFrontName() {
        return frontName;
    }

    public void setFrontName(String frontName) {
        this.frontName = frontName;
    }

    public List<Category> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<Category> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
