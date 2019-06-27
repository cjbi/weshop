package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.marketing.api.CommentApi;
import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.query.CommentQuery;

import java.util.Collections;
import java.util.List;

@Component
public class CommentApiFallback extends ApiFallback<Comment> implements CommentApi {

    @Override
    public List<Comment> queryIfRequirePictureList(CommentQuery commentQuery) {
        return Collections.emptyList();
    }
}
