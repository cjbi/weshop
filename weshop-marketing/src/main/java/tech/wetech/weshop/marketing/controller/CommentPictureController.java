package tech.wetech.weshop.marketing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.marketing.api.CommentPictureApi;
import tech.wetech.weshop.marketing.po.CommentPicture;
import tech.wetech.weshop.marketing.service.CommentPictureService;

import java.util.List;

@RestController
@RequestMapping("/commentPicture")
public class CommentPictureController extends BaseApi<CommentPicture> implements CommentPictureApi {

    @Autowired
    private CommentPictureService commentPictureService;

    @Override
    public Result<List<String>> queryPicUrlByCommentId(Integer commentId) {
        return Result.success(commentPictureService.queryPicUrlByCommentId(commentId));
    }
}
