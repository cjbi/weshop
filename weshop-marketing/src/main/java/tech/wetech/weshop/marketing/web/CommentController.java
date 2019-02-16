package tech.wetech.weshop.marketing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.marketing.api.CommentApi;
import tech.wetech.weshop.marketing.dto.CommentCountDTO;
import tech.wetech.weshop.marketing.dto.CommentResultDTO;
import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.query.CommentQuery;
import tech.wetech.weshop.marketing.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController extends BaseApi<Comment> implements CommentApi {

    @Autowired
    private CommentService commentService;

    @Override
    public List<CommentResultDTO> queryList(CommentQuery commentQuery) {
        return commentService.queryList(commentQuery);
    }

    @Override
    public CommentCountDTO countList(CommentQuery commentQuery) {
        return commentService.countList(commentQuery);
    }
}
