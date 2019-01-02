package tech.wetech.weshop.vo;

public class AddOrDeleteResultVO {

    private HandleType handleType;

    public AddOrDeleteResultVO(HandleType handleType) {
        this.handleType = handleType;
    }

    public enum HandleType{
        add,delete
    }

    public HandleType getHandleType() {
        return handleType;
    }

    public AddOrDeleteResultVO setHandleType(HandleType handleType) {
        this.handleType = handleType;
        return this;
    }
}
