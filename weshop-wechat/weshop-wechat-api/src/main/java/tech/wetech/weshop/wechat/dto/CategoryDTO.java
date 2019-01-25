package tech.wetech.weshop.wechat.dto;

import tech.wetech.weshop.enums.CategoryLevelEnum;
import tech.wetech.weshop.po.Category;

import java.util.List;

public class CategoryDTO {

    private Integer id;

    private String name;

    private String keywords;

    private String frontDesc;

    private Integer parentId;

    private Boolean sortOrder;

    private Boolean showIndex;

    private Boolean show;

    private String bannerUrl;

    private String iconUrl;

    private String imgUrl;

    private String wapBannerUrl;

    private CategoryLevelEnum level;

    private Integer type;

    private String frontName;

    private List<Category> subCategoryList;

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.keywords = category.getKeywords();
        this.frontDesc = category.getFrontDesc();
        this.parentId = category.getParentId();
        this.sortOrder = category.getSortOrder();
        this.showIndex = category.getShowIndex();
        this.show = category.getShow();
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

    public CategoryDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public CategoryDTO setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public String getFrontDesc() {
        return frontDesc;
    }

    public CategoryDTO setFrontDesc(String frontDesc) {
        this.frontDesc = frontDesc;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public CategoryDTO setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public Boolean getSortOrder() {
        return sortOrder;
    }

    public CategoryDTO setSortOrder(Boolean sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public Boolean getShowIndex() {
        return showIndex;
    }

    public CategoryDTO setShowIndex(Boolean showIndex) {
        this.showIndex = showIndex;
        return this;
    }

    public Boolean getShow() {
        return show;
    }

    public CategoryDTO setShow(Boolean show) {
        this.show = show;
        return this;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public CategoryDTO setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public CategoryDTO setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public CategoryDTO setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getWapBannerUrl() {
        return wapBannerUrl;
    }

    public CategoryDTO setWapBannerUrl(String wapBannerUrl) {
        this.wapBannerUrl = wapBannerUrl;
        return this;
    }

    public CategoryLevelEnum getLevel() {
        return level;
    }

    public CategoryDTO setLevel(CategoryLevelEnum level) {
        this.level = level;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public CategoryDTO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getFrontName() {
        return frontName;
    }

    public CategoryDTO setFrontName(String frontName) {
        this.frontName = frontName;
        return this;
    }

    public List<Category> getSubCategoryList() {
        return subCategoryList;
    }

    public CategoryDTO setSubCategoryList(List<Category> subCategoryList) {
        this.subCategoryList = subCategoryList;
        return this;
    }
}
