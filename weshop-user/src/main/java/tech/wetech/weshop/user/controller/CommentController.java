package tech.wetech.weshop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.user.api.CommentApi;
import tech.wetech.weshop.user.po.Comment;
import tech.wetech.weshop.user.query.CommentQuery;
import tech.wetech.weshop.user.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController extends BaseApi<Comment> implements CommentApi {

    @Autowired
    private CommentService commentService;

    @Override
    public ResultWrapper<List<Comment>> queryIfRequirePictureList(CommentQuery commentQuery) {
        return ResultWrapper.success(commentService.queryIfRequirePictureList(commentQuery));
    }

    @Override
    public ResultWrapper<Integer> countIfRequirePictureList(CommentQuery commentQuery) {
        return ResultWrapper.success(commentService.countIfRequirePictureList(commentQuery));
    }
}
