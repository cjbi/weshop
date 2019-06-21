package tech.wetech.weshop.marketing.query;

import tech.wetech.weshop.common.query.PageQuery;

import javax.validation.constraints.NotNull;

public class CommentQuery extends PageQuery {

    @NotNull
    private Integer typeId;

    @NotNull
    private Integer valueId;

    private boolean requirePicture;

    public Integer getTypeId() {
        return typeId;
    }

    public CommentQuery setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public Integer getValueId() {
        return valueId;
    }

    public CommentQuery setValueId(Integer valueId) {
        this.valueId = valueId;
        return this;
    }

    public boolean getRequirePicture() {
        return requirePicture;
    }

    public CommentQuery setRequirePicture(boolean requirePicture) {
        this.requirePicture = requirePicture;
        return this;
    }
}
