package tech.wetech.weshop.wechat.dto;

public class CollectAddOrDeleteParamDTO {

    private Integer valueId;

    private Integer typeId;

    public Integer getValueId() {
        return valueId;
    }

    public CollectAddOrDeleteParamDTO setValueId(Integer valueId) {
        this.valueId = valueId;
        return this;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public CollectAddOrDeleteParamDTO setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }
}
