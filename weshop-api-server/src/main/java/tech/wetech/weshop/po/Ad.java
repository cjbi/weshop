package tech.wetech.weshop.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "weshop_ad")
public class Ad {
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

    /**
     * @return id
     */
    public Short getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * @return ad_position_id
     */
    public Short getAdPositionId() {
        return adPositionId;
    }

    /**
     * @param adPositionId
     */
    public void setAdPositionId(Short adPositionId) {
        this.adPositionId = adPositionId;
    }

    /**
     * @return media_type
     */
    public Byte getMediaType() {
        return mediaType;
    }

    /**
     * @param mediaType
     */
    public void setMediaType(Byte mediaType) {
        this.mediaType = mediaType;
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
     * @return link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return enabled
     */
    public Byte getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    /**
     * @return image_url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}