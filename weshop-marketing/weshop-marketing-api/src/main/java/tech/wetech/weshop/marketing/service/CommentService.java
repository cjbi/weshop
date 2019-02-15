package tech.wetech.weshop.marketing.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.marketing.dto.CommentCountDTO;
import tech.wetech.weshop.marketing.dto.CommentResultDTO;
import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.query.CommentQuery;
import tech.wetech.weshop.service.IService;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
@RequestMapping("/comment")
public interface CommentService extends IService<Comment> {

    @GetMapping("/queryList")
    List<CommentResultDTO> queryList(CommentQuery commentQuery);

    @GetMapping("/countList")
    CommentCountDTO countList(CommentQuery commentQuery);
}
