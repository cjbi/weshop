package tech.wetech.weshop.domain;

import tech.wetech.weshop.vo.CreateKeywordsFormVO;
import tech.wetech.weshop.vo.UpdateKeywordsFormVO;

import javax.persistence.*;

@Table(name = "weshop_keywords")
public class Keywords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String keyword;

    @Column(name = "is_hot")
    private Boolean isHot;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "is_show")
    private Boolean isShow;

    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 关键词的跳转链接
     */
    @Column(name = "`scheme _url`")
    private String schemeUrl;

    private Integer type;

    public Keywords() {
    }

    public Keywords(CreateKeywordsFormVO createKeywordsFormVO) {
        this.keyword = createKeywordsFormVO.getKeyword();
        this.isHot = createKeywordsFormVO.getIsHot();
        this.isDefault = createKeywordsFormVO.getIsDefault();
        this.isShow = createKeywordsFormVO.getIsShow();
        this.sortOrder = createKeywordsFormVO.getSortOrder();
        this.schemeUrl = createKeywordsFormVO.getSchemeUrl();
        this.type = createKeywordsFormVO.getType();
    }

    public Keywords(UpdateKeywordsFormVO updateKeywordsFormVO) {
        this.id = updateKeywordsFormVO.getId();
        this.keyword = updateKeywordsFormVO.getKeyword();
        this.isHot = updateKeywordsFormVO.getIsHot();
        this.isDefault = updateKeywordsFormVO.getIsDefault();
        this.isShow = updateKeywordsFormVO.getIsShow();
        this.sortOrder = updateKeywordsFormVO.getSortOrder();
        this.schemeUrl = updateKeywordsFormVO.getSchemeUrl();
        this.type = updateKeywordsFormVO.getType();
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
     * @return keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return is_hot
     */
    public Boolean getIsHot() {
        return isHot;
    }

    /**
     * @param isHot
     */
    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    /**
     * @return is_default
     */
    public Boolean getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault
     */
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
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
     * 获取关键词的跳转链接
     *
     * @return scheme _url - 关键词的跳转链接
     */
    public String getSchemeUrl() {
        return schemeUrl;
    }

    /**
     * 设置关键词的跳转链接
     *
     * @param schemeUrl 关键词的跳转链接
     */
    public void setSchemeUrl(String schemeUrl) {
        this.schemeUrl = schemeUrl;
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
}