package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.wechat.dto.CommentCountDTO;
import tech.wetech.weshop.wechat.dto.CommentResultDTO;
import tech.wetech.weshop.po.Comment;
import tech.wetech.weshop.query.CommentQuery;
import tech.wetech.weshop.service.IService;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface CommentService extends IService<Comment> {

    List<CommentResultDTO> queryList(CommentQuery commentQuery);

    CommentCountDTO countList(CommentQuery commentQuery);
}
