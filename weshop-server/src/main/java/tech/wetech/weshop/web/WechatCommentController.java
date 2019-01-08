package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.query.CommentQuery;
import tech.wetech.weshop.service.CommentService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CommentPostVO;
import tech.wetech.weshop.vo.CommentResultVO;

import java.util.List;

@RestController
@RequestMapping("/wechat/comment")
public class WechatCommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public Result<List<CommentResultVO>> queryList(@Validated CommentQuery commentQuery) {
        return Result.success(commentService.queryList(commentQuery))
                .addExtra("total", commentService.countList(commentQuery));
    }

    @GetMapping("/count")
    public Result<Long> countList(@Validated CommentQuery commentQuery) {
        return Result.success(commentService.countList(commentQuery));
    }

    @PostMapping
    public Result postComment(@RequestBody @Validated CommentPostVO commentPostVO) {
        commentService.create(commentPostVO.toPO());
        return Result.success();
    }

}
