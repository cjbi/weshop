package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Comment;
import tech.wetech.weshop.query.CommentQuery;
import tech.wetech.weshop.vo.CommentResultVO;

import java.util.List;

/**
 * @author cjbi
 */
public interface CommentService extends IService<Comment> {

    List<CommentResultVO> queryList(CommentQuery commentQuery);

    long countList(CommentQuery commentQuery);
}
