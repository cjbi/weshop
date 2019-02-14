package tech.wetech.weshop.marketing.mapper;

import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.query.CommentQuery;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface CommentMapper extends MyMapper<Comment> {

    /**
     * 查询有图片的评论
     *
     * @return
     */
    List<Comment> selectIfRequirePictureList(CommentQuery commentQuery);
}