package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.marketing.api.CommentApi;
import tech.wetech.weshop.marketing.dto.CommentCountDTO;
import tech.wetech.weshop.marketing.dto.CommentPostDTO;
import tech.wetech.weshop.marketing.dto.CommentResultDTO;
import tech.wetech.weshop.marketing.query.CommentQuery;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.BaseController;

import java.util.List;

@RestController
@RequestMapping("/wechat/comment")
public class WechatCommentController extends BaseController {

    @Autowired
    private CommentApi commentApi;

    @GetMapping("/list")
    public Result<List<CommentResultDTO>> queryList(@Validated CommentQuery commentQuery) {
        return commentApi.queryList(commentQuery);
    }

    @GetMapping("/count")
    public Result<CommentCountDTO> countList(@Validated CommentQuery commentQuery) {
        return commentApi.countList(commentQuery);
    }

    @PostMapping("post")
    public Result postComment(@RequestBody @Validated CommentPostDTO commentPostDTO) {
        return commentApi.create(commentPostDTO.toPO());
    }

}
