package tech.wetech.weshop.marketing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.marketing.api.CommentApi;
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
    public Result<List<Comment>> queryIfRequirePictureList(CommentQuery commentQuery) {
        return Result.success(commentService.queryIfRequirePictureList(commentQuery));
    }

    @Override
    public Result<Integer> countIfRequirePictureList(CommentQuery commentQuery) {
        return Result.success(commentService.countIfRequirePictureList(commentQuery));
    }
}
