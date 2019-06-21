package tech.wetech.weshop.marketing.service;

import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.marketing.dto.CommentCountDTO;
import tech.wetech.weshop.marketing.dto.CommentResultDTO;
import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.query.CommentQuery;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface CommentService extends IService<Comment> {

    List<CommentResultDTO> queryList(CommentQuery commentQuery);

    CommentCountDTO countList(CommentQuery commentQuery);
}
