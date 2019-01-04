package tech.wetech.weshop.po;

import javax.persistence.*;

@Table(name = "weshop_user_level")
public class UserLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    private String name;

    private String description;

    public Byte getId() {
        return id;
    }

    public UserLevel setId(Byte id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserLevel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UserLevel setDescription(String description) {
        this.description = description;
        return this;
    }
}