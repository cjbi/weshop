package tech.wetech.weshop.user.dto;

public class CollectAddOrDeleteResultDTO {

    private HandleType type;

    public CollectAddOrDeleteResultDTO(HandleType type) {
        this.type = type;
    }

    public enum HandleType {
        add, delete
    }

    public HandleType getType() {
        return type;
    }

    public CollectAddOrDeleteResultDTO setType(HandleType type) {
        this.type = type;
        return this;
    }
}
