package tech.wetech.weshop.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "weshop_storage")
public class StoragePO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文件的唯一索引
     */
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
     * 文件来源
     */
    private String source;

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
     * 获取文件的唯一索引
     *
     * @return key - 文件的唯一索引
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置文件的唯一索引
     *
     * @param key 文件的唯一索引
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 获取文件名
     *
     * @return name - 文件名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文件名
     *
     * @param name 文件名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取文件类型
     *
     * @return type - 文件类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置文件类型
     *
     * @param type 文件类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取文件大小
     *
     * @return size - 文件大小
     */
    public Long getSize() {
        return size;
    }

    /**
     * 设置文件大小
     *
     * @param size 文件大小
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * 获取文件访问链接
     *
     * @return url - 文件访问链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置文件访问链接
     *
     * @param url 文件访问链接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取文件来源
     *
     * @return source - 文件来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置文件来源
     *
     * @param source 文件来源
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}