package tech.wetech.weshop.po;

import javax.persistence.*;

@Table(name = "weshop_ad_position")
public class AdPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    private String name;

    private Short width;

    private Short height;

    private String desc;

    /**
     * @return id
     */
    public Byte getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Byte id) {
        this.id = id;
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
     * @return width
     */
    public Short getWidth() {
        return width;
    }

    /**
     * @param width
     */
    public void setWidth(Short width) {
        this.width = width;
    }

    /**
     * @return height
     */
    public Short getHeight() {
        return height;
    }

    /**
     * @param height
     */
    public void setHeight(Short height) {
        this.height = height;
    }

    /**
     * @return desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
}