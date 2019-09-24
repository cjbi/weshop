package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.user.fallback.CommentApiFallback;
import tech.wetech.weshop.user.po.Comment;
import tech.wetech.weshop.user.query.CommentQuery;

import java.util.List;

@FeignClient(value = "weshop-user", path = "comment", fallback = CommentApiFallback.class)
public interface CommentApi extends Api<Comment> {

    @GetMapping("/queryIfRequirePictureList")
    ResultWrapper<List<Comment>> queryIfRequirePictureList(@RequestBody CommentQuery commentQuery);

    @GetMapping("/countIfRequirePictureList")
    ResultWrapper<Integer> countIfRequirePictureList(@RequestBody CommentQuery commentQuery);

}
