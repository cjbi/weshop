package tech.wetech.weshop.user.enums;

/**
 * @author cjbi@outlook.com
 */
public enum RegionTypeEnum {

    COUNTRY("国家"), PROVINCE("省份"), CITY("城市"), DISTRICT("区县");

    private String name;

    RegionTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
