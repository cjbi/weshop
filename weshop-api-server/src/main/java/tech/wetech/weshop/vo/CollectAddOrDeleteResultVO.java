package tech.wetech.weshop.vo;

public class CollectAddOrDeleteResultVO {

    private HandleType handleType;

    public CollectAddOrDeleteResultVO(HandleType handleType) {
        this.handleType = handleType;
    }

    public enum HandleType{
        add,delete
    }

    public HandleType getHandleType() {
        return handleType;
    }

    public CollectAddOrDeleteResultVO setHandleType(HandleType handleType) {
        this.handleType = handleType;
        return this;
    }
}
