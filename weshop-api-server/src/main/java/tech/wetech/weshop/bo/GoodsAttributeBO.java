package tech.wetech.weshop.bo;

import tech.wetech.weshop.vo.GoodsDetailVO;

public class GoodsAttributeBO {

    private String name;

    private String value;

    public GoodsDetailVO.GoodsAttributeVO toGoodsAttributeVO() {
        GoodsDetailVO.GoodsAttributeVO goodsAttributeVO = new GoodsDetailVO.GoodsAttributeVO();
        goodsAttributeVO.setName(this.name);
        goodsAttributeVO.setValue(this.value);
        return goodsAttributeVO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
