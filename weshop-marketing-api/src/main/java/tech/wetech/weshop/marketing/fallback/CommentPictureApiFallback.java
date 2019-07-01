package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.ResultCodeEnum;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.marketing.api.CommentPictureApi;
import tech.wetech.weshop.marketing.po.CommentPicture;

import java.util.List;

@Component
public class CommentPictureApiFallback extends ApiFallback<CommentPicture> implements CommentPictureApi {
    @Override
    public Result<List<String>> queryPicUrlByCommentId(Integer commentId) {
        return Result.failure(ResultCodeEnum.REMOTE_SERVICE_ERROR);
    }
}
