package tech.wetech.weshop.goods.po;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "weshop_channel")
public class Channel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String url;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "sort_order")
    private Integer sortOrder;

    public Integer getId() {
        return id;
    }

    public Channel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Channel setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Channel setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public Channel setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public Channel setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
        return this;
    }
}