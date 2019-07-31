package tech.wetech.weshop.user.po;

import javax.persistence.*;

@Table(name = "weshop_topic_category")
public class TopicCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "pic_url")
    private String picUrl;

    public Integer getId() {
        return id;
    }

    public TopicCategory setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TopicCategory setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public TopicCategory setPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }
}
