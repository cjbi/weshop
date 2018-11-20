package tech.wetech.weshop.enums;

/**
 * @author cjbi
 */
public enum  CategoryLevelEnum {

    L1("一级类目"),L2("二级类目");

    CategoryLevelEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
