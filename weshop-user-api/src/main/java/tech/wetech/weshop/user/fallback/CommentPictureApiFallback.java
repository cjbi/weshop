package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.user.api.CommentPictureApi;
import tech.wetech.weshop.user.po.CommentPicture;

import java.util.List;

@Component
public class CommentPictureApiFallback extends ApiFallback<CommentPicture> implements CommentPictureApi {
    @Override
    public ResultWrapper<List<String>> queryPicUrlByCommentId(Integer commentId) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }
}
