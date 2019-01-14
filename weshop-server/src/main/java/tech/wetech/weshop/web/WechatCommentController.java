package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.query.CommentQuery;
import tech.wetech.weshop.service.CommentService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CommentCountVO;
import tech.wetech.weshop.vo.CommentPostVO;
import tech.wetech.weshop.vo.CommentResultVO;
import tech.wetech.weshop.web.base.BaseController;

import java.util.List;

@RestController
@RequestMapping("/wechat/comment")
public class WechatCommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public Result<List<CommentResultVO>> queryList(@Validated CommentQuery commentQuery) {
        return Result.success(commentService.queryList(commentQuery));
    }

    @GetMapping("/count")
    public Result<CommentCountVO> countList(@Validated CommentQuery commentQuery) {
        return Result.success(commentService.countList(commentQuery));
    }

    @PostMapping("post")
    public Result postComment(@RequestBody @Validated CommentPostVO commentPostVO) {
        commentService.create(commentPostVO.toPO());
        return Result.success();
    }

}
