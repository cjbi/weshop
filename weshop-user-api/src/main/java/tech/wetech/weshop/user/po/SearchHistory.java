package tech.wetech.weshop.user.po;

import javax.persistence.*;
import java.util.Date;

@Table(name = "weshop_search_history")
public class SearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String keyword;

    /**
     * 搜索来源，如PC、小程序、APP等
     */
    @Column(name = "`from`")
    private String from;

    /**
     * 搜索时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "user_id")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public SearchHistory setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public SearchHistory setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public SearchHistory setFrom(String from) {
        this.from = from;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SearchHistory setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public SearchHistory setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }
}
