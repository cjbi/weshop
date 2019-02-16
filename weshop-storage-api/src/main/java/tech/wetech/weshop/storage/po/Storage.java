package tech.wetech.weshop.storage.po;

import javax.persistence.*;
import java.util.Date;

@Table(name = "weshop_storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文件的唯一索引
     */
    @Column(name = "`key`")
    private String key;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 文件访问链接
     */
    private String url;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public Storage setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getKey() {
        return key;
    }

    public Storage setKey(String key) {
        this.key = key;
        return this;
    }

    public String getName() {
        return name;
    }

    public Storage setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Storage setType(String type) {
        this.type = type;
        return this;
    }

    public Long getSize() {
        return size;
    }

    public Storage setSize(Long size) {
        this.size = size;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Storage setUrl(String url) {
        this.url = url;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Storage setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Storage setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}