package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.enums.ResultStatus;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.marketing.api.CommentApi;
import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.query.CommentQuery;

import java.util.List;

@Component
public class CommentApiFallback extends ApiFallback<Comment> implements CommentApi {

    @Override
    public Result<List<Comment>> queryIfRequirePictureList(CommentQuery commentQuery) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public Result<Integer> countIfRequirePictureList(CommentQuery commentQuery) {
        return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
    }
}
