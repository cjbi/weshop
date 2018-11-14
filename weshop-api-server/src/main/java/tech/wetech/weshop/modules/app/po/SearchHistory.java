package tech.wetech.weshop.modules.app.po;

import javax.persistence.*;

@Table(name = "weshop_search_history")
public class SearchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String keyword;

    /**
     * 搜索来源，如PC、小程序、APP等
     */
    private String from;

    /**
     * 搜索时间
     */
    @Column(name = "add_time")
    private Integer addTime;

    @Column(name = "user_id")
    private String userId;

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
     * @return add_time - 搜索时间
     */
    public Integer getAddTime() {
        return addTime;
    }

    /**
     * 设置搜索时间
     *
     * @param addTime 搜索时间
     */
    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}