package tech.wetech.weshop.goods.bo;

public class GoodsAttributeBO {

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public GoodsAttributeBO setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public GoodsAttributeBO setValue(String value) {
        this.value = value;
        return this;
    }
}
