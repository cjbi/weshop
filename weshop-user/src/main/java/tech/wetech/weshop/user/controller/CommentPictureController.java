package tech.wetech.weshop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.user.api.CommentPictureApi;
import tech.wetech.weshop.user.po.CommentPicture;
import tech.wetech.weshop.user.service.CommentPictureService;

import java.util.List;

@RestController
@RequestMapping("/commentPicture")
public class CommentPictureController extends BaseApi<CommentPicture> implements CommentPictureApi {

    @Autowired
    private CommentPictureService commentPictureService;

    @Override
    public ResultWrapper<List<String>> queryPicUrlByCommentId(Integer commentId) {
        return ResultWrapper.success(commentPictureService.queryPicUrlByCommentId(commentId));
    }
}
