package tech.wetech.weshop.wechat.vo;

import tech.wetech.weshop.goods.enums.CategoryLevelEnum;
import tech.wetech.weshop.goods.po.Category;

import java.util.List;

public class CategoryVO {

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

    public CategoryVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public CategoryVO setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public String getFrontDesc() {
        return frontDesc;
    }

    public CategoryVO setFrontDesc(String frontDesc) {
        this.frontDesc = frontDesc;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public CategoryVO setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public Boolean getSortOrder() {
        return sortOrder;
    }

    public CategoryVO setSortOrder(Boolean sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public Boolean getShowIndex() {
        return showIndex;
    }

    public CategoryVO setShowIndex(Boolean showIndex) {
        this.showIndex = showIndex;
        return this;
    }

    public Boolean getShow() {
        return show;
    }

    public CategoryVO setShow(Boolean show) {
        this.show = show;
        return this;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public CategoryVO setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public CategoryVO setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public CategoryVO setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public String getWapBannerUrl() {
        return wapBannerUrl;
    }

    public CategoryVO setWapBannerUrl(String wapBannerUrl) {
        this.wapBannerUrl = wapBannerUrl;
        return this;
    }

    public CategoryLevelEnum getLevel() {
        return level;
    }

    public CategoryVO setLevel(CategoryLevelEnum level) {
        this.level = level;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public CategoryVO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getFrontName() {
        return frontName;
    }

    public CategoryVO setFrontName(String frontName) {
        this.frontName = frontName;
        return this;
    }

    public List<Category> getSubCategoryList() {
        return subCategoryList;
    }

    public CategoryVO setSubCategoryList(List<Category> subCategoryList) {
        this.subCategoryList = subCategoryList;
        return this;
    }
}
