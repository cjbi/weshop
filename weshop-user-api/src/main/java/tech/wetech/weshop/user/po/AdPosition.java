package tech.wetech.weshop.user.po;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "weshop_ad_position")
public class AdPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    private String name;

    private Short width;

    private Short height;

    private String desc;

    public Byte getId() {
        return id;
    }

    public AdPosition setId(Byte id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AdPosition setName(String name) {
        this.name = name;
        return this;
    }

    public Short getWidth() {
        return width;
    }

    public AdPosition setWidth(Short width) {
        this.width = width;
        return this;
    }

    public Short getHeight() {
        return height;
    }

    public AdPosition setHeight(Short height) {
        this.height = height;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public AdPosition setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
