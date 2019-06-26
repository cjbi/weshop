package tech.wetech.weshop.wechat.vo;

public class CommentCountVO {

    private long allCount;

    private long hasPicCount;

    public CommentCountVO() {
    }

    public CommentCountVO(long allCount, long hasPicCount) {
        this.allCount = allCount;
        this.hasPicCount = hasPicCount;
    }

    public long getAllCount() {
        return allCount;
    }

    public CommentCountVO setAllCount(long allCount) {
        this.allCount = allCount;
        return this;
    }

    public long getHasPicCount() {
        return hasPicCount;
    }

    public CommentCountVO setHasPicCount(long hasPicCount) {
        this.hasPicCount = hasPicCount;
        return this;
    }
}
