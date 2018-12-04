package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.Comment;
import tech.wetech.weshop.query.CommentPageQuery;

/**
 * @author cjbi
 */
public interface CommentService {


    /**
     * 查询评论
     * @param commentPageQuery
     * @return
     */
    PageInfo<Comment> queryCommentPageInfo(CommentPageQuery commentPageQuery);

    /**
     * 删除评论
     * @param commentId
     */
    void deleteComment(Integer commentId);

}
