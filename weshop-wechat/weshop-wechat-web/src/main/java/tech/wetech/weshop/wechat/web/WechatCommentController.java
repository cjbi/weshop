package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.query.CommentQuery;
import tech.wetech.weshop.web.BaseController;
import tech.wetech.weshop.wechat.service.CommentService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.wechat.dto.CommentCountDTO;
import tech.wetech.weshop.wechat.dto.CommentPostDTO;
import tech.wetech.weshop.wechat.dto.CommentResultDTO;

import java.util.List;

@RestController
@RequestMapping("/wechat/comment")
public class WechatCommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public Result<List<CommentResultDTO>> queryList(@Validated CommentQuery commentQuery) {
        return Result.success(commentService.queryList(commentQuery));
    }

    @GetMapping("/count")
    public Result<CommentCountDTO> countList(@Validated CommentQuery commentQuery) {
        return Result.success(commentService.countList(commentQuery));
    }

    @PostMapping("post")
    public Result postComment(@RequestBody @Validated CommentPostDTO commentPostDTO) {
        commentService.create(commentPostDTO.toPO());
        return Result.success();
    }

}
