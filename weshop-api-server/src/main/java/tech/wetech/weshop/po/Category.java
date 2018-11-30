package tech.wetech.weshop.po;

import tech.wetech.weshop.enums.CategoryLevelEnum;
import tech.wetech.weshop.vo.CreateCategoryFormVO;
import tech.wetech.weshop.vo.UpdateCategoryFormVO;

import javax.persistence.*;

/**
 * @author cjbi
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
    private Boolean isShow;

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

    public Category() {
    }

    public Category(CreateCategoryFormVO updateCategoryFormVO) {
        this.name = updateCategoryFormVO.getName();
        this.keywords = updateCategoryFormVO.getKeywords();
        this.frontDesc = updateCategoryFormVO.getFrontDesc();
        this.parentId = updateCategoryFormVO.getParentId();
        this.sortOrder = updateCategoryFormVO.getSortOrder();
        this.showIndex = updateCategoryFormVO.getShowIndex();
        this.isShow = updateCategoryFormVO.getIsShow();
        this.bannerUrl = updateCategoryFormVO.getBannerUrl();
        this.iconUrl = updateCategoryFormVO.getIconUrl();
        this.imgUrl = updateCategoryFormVO.getImgUrl();
        this.wapBannerUrl = updateCategoryFormVO.getWapBannerUrl();
        this.level = updateCategoryFormVO.getLevel();
        this.type = updateCategoryFormVO.getType();
        this.frontName = updateCategoryFormVO.getFrontName();
    }

    public Category(UpdateCategoryFormVO updateCategoryFormVO) {
        this.id = updateCategoryFormVO.getId();
        this.name = updateCategoryFormVO.getName();
        this.keywords = updateCategoryFormVO.getKeywords();
        this.frontDesc = updateCategoryFormVO.getFrontDesc();
        this.parentId = updateCategoryFormVO.getParentId();
        this.sortOrder = updateCategoryFormVO.getSortOrder();
        this.showIndex = updateCategoryFormVO.getShowIndex();
        this.isShow = updateCategoryFormVO.getIsShow();
        this.bannerUrl = updateCategoryFormVO.getBannerUrl();
        this.iconUrl = updateCategoryFormVO.getIconUrl();
        this.imgUrl = updateCategoryFormVO.getImgUrl();
        this.wapBannerUrl = updateCategoryFormVO.getWapBannerUrl();
        this.level = updateCategoryFormVO.getLevel();
        this.type = updateCategoryFormVO.getType();
        this.frontName = updateCategoryFormVO.getFrontName();
    }

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