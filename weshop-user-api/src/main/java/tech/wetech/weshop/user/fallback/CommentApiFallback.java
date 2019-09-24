package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.user.api.CommentApi;
import tech.wetech.weshop.user.po.Comment;
import tech.wetech.weshop.user.query.CommentQuery;

import java.util.List;

@Component
public class CommentApiFallback extends ApiFallback<Comment> implements CommentApi {

    @Override
    public ResultWrapper<List<Comment>> queryIfRequirePictureList(CommentQuery commentQuery) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<Integer> countIfRequirePictureList(CommentQuery commentQuery) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }
}
