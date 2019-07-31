package tech.wetech.weshop.user.mapper;

import tech.wetech.weshop.common.utils.MyMapper;
import tech.wetech.weshop.user.po.Comment;
import tech.wetech.weshop.user.query.CommentQuery;

import java.util.List;

public interface CommentMapper extends MyMapper<Comment> {

    /**
     * 查询有图片的评论
     *
     * @return
     */
    List<Comment> selectIfRequirePictureList(CommentQuery commentQuery, int offset, int limit);

    Integer countIfRequirePictureList(CommentQuery commentQuery);

}
