package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.user.fallback.CommentPictureApiFallback;
import tech.wetech.weshop.user.po.CommentPicture;

import java.util.List;

@FeignClient(value = "weshop-user", path = "commentPicture", fallback = CommentPictureApiFallback.class)
public interface CommentPictureApi extends Api<CommentPicture> {

    @GetMapping("/queryPicUrlByCommentId")
    Result<List<String>> queryPicUrlByCommentId(@RequestParam("commentId") Integer commentId);

}
