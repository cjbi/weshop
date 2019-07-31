package tech.wetech.weshop.user.po;

import javax.persistence.*;

@Table(name = "weshop_keywords")
public class Keywords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String keyword;

    @Column(name = "is_hot")
    private Boolean hot;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "is_show")
    private Boolean show;

    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 关键词的跳转链接
     */
    @Column(name = "`scheme _url`")
    private String schemeUrl;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public Keywords setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public Keywords setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public Boolean getHot() {
        return hot;
    }

    public Keywords setHot(Boolean hot) {
        this.hot = hot;
        return this;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public Keywords setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
        return this;
    }

    public Boolean getShow() {
        return show;
    }

    public Keywords setShow(Boolean show) {
        this.show = show;
        return this;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public Keywords setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }

    public String getSchemeUrl() {
        return schemeUrl;
    }

    public Keywords setSchemeUrl(String schemeUrl) {
        this.schemeUrl = schemeUrl;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Keywords setType(Integer type) {
        this.type = type;
        return this;
    }
}
