package tech.wetech.weshop.enums;

/**
 * @author cjbi
 */

public enum GenderEnum {
    UNKNOWN("未知"),
    MALE("男"),
    FEMALE("女");

    private String name;

    GenderEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
