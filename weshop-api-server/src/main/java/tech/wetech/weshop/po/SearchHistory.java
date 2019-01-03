package tech.wetech.weshop.po;

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
     * 获取搜索来源，如PC、小程序、APP等
     *
     * @return from - 搜索来源，如PC、小程序、APP等
     */
    public String getFrom() {
        return from;
    }

    /**
     * 设置搜索来源，如PC、小程序、APP等
     *
     * @param from 搜索来源，如PC、小程序、APP等
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * 获取搜索时间
     *
     * @return create_time - 搜索时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置搜索时间
     *
     * @param createTime 搜索时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}