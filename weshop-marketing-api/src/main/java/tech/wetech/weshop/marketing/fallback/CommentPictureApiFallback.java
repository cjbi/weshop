package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.marketing.api.CommentPictureApi;
import tech.wetech.weshop.marketing.po.CommentPicture;

import java.util.Collections;
import java.util.List;

@Component
public class CommentPictureApiFallback extends ApiFallback<CommentPicture> implements CommentPictureApi {
    @Override
    public List<String> queryPicUrlByCommentId(Integer commentId) {
        return Collections.emptyList();
    }
}
