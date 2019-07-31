package tech.wetech.weshop.user.service;

import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.user.po.Comment;
import tech.wetech.weshop.user.query.CommentQuery;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface CommentService extends IService<Comment> {

    List<Comment> queryIfRequirePictureList(CommentQuery commentQuery);

    Integer countIfRequirePictureList(CommentQuery commentQuery);
}
