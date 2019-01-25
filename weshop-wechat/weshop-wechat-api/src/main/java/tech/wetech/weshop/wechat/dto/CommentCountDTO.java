package tech.wetech.weshop.wechat.dto;

public class CommentCountDTO {

    private long allCount;

    private long hasPicCount;

    public CommentCountDTO() {
    }

    public CommentCountDTO(long allCount, long hasPicCount) {
        this.allCount = allCount;
        this.hasPicCount = hasPicCount;
    }

    public long getAllCount() {
        return allCount;
    }

    public CommentCountDTO setAllCount(long allCount) {
        this.allCount = allCount;
        return this;
    }

    public long getHasPicCount() {
        return hasPicCount;
    }

    public CommentCountDTO setHasPicCount(long hasPicCount) {
        this.hasPicCount = hasPicCount;
        return this;
    }
}
