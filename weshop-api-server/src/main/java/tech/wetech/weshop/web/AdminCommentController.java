package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Comment;
import tech.wetech.weshop.query.CommentPageQuery;
import tech.wetech.weshop.service.CommentService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.PageInfoVO;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/comment")
public class AdminCommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public Result<PageInfoVO<Comment>> queryCommentPageInfo(CommentPageQuery commentPageQuery) {
        PageInfo<Comment> commentPageInfo = commentService.queryCommentPageInfo(commentPageQuery);
        PageInfoVO<Comment> pageInfoVO = new PageInfoVO<>(commentPageInfo);
        return Result.success(pageInfoVO);
    }

    @DeleteMapping("/{commentId}")
    public Result deleteComment(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
        return Result.success();
    }

}
