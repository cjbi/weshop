package tech.wetech.weshop.user.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "weshop_ad")
public class Ad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "ad_position_id")
    private Short adPositionId;

    @Column(name = "media_type")
    private Byte mediaType;

    private String name;

    private String link;

    private String content;

    @Column(name = "end_time")
    private Date endTime;

    private Byte enabled;

    @Column(name = "image_url")
    private String imageUrl;

    public Short getId() {
        return id;
    }

    public Ad setId(Short id) {
        this.id = id;
        return this;
    }

    public Short getAdPositionId() {
        return adPositionId;
    }

    public Ad setAdPositionId(Short adPositionId) {
        this.adPositionId = adPositionId;
        return this;
    }

    public Byte getMediaType() {
        return mediaType;
    }

    public Ad setMediaType(Byte mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public String getName() {
        return name;
    }

    public Ad setName(String name) {
        this.name = name;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Ad setLink(String link) {
        this.link = link;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Ad setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Ad setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Byte getEnabled() {
        return enabled;
    }

    public Ad setEnabled(Byte enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Ad setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
