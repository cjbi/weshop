package tech.wetech.weshop.goods.dto;

public class GoodsAttributeDTO {

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public GoodsAttributeDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public GoodsAttributeDTO setValue(String value) {
        this.value = value;
        return this;
    }
}
