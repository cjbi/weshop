package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.api.CommentApi;
import tech.wetech.weshop.user.query.CommentQuery;
import tech.wetech.weshop.wechat.service.WechatCommentService;
import tech.wetech.weshop.wechat.vo.CommentCountVO;
import tech.wetech.weshop.wechat.vo.CommentPostVO;
import tech.wetech.weshop.wechat.vo.CommentResultVO;

import java.util.List;

@RestController
@RequestMapping("/wechat/comment")
public class WechatCommentController extends BaseController {

    @Autowired
    private WechatCommentService wechatCommentService;

    @Autowired
    private CommentApi commentApi;

    @GetMapping("/list")
    public Result<List<CommentResultVO>> queryList(@Validated CommentQuery commentQuery) {
        return Result.success(wechatCommentService.queryList(commentQuery));
    }

    @GetMapping("/count")
    public Result<CommentCountVO> countList(@Validated CommentQuery commentQuery) {
        return Result.success(wechatCommentService.countList(commentQuery));
    }

    @PostMapping("post")
    public Result postComment(@RequestBody @Validated CommentPostVO commentPostDTO) {
        return commentApi.create(commentPostDTO.toPO());
    }

}
