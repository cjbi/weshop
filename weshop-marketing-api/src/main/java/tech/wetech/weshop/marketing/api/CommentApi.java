package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.marketing.fallback.CommentApiFallback;
import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.query.CommentQuery;

import java.util.List;

@FeignClient(value = "weshop-marketing", path = "comment", fallback = CommentApiFallback.class)
public interface CommentApi extends Api<Comment> {

    @GetMapping("/queryIfRequirePictureList")
    Result<List<Comment>> queryIfRequirePictureList(@RequestBody CommentQuery commentQuery);

    @GetMapping("/countIfRequirePictureList")
    Result<Integer> countIfRequirePictureList(@RequestBody CommentQuery commentQuery);

}
