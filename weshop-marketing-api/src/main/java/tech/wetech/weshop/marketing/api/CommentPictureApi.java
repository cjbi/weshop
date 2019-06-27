package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.marketing.fallback.CommentPictureApiFallback;
import tech.wetech.weshop.marketing.po.CommentPicture;

import java.util.List;

@FeignClient(value = "weshop-marketing", path = "commentPicture", fallback = CommentPictureApiFallback.class)
public interface CommentPictureApi extends Api<CommentPicture> {

    @GetMapping("/queryPicUrlByCommentId")
    List<String> queryPicUrlByCommentId(@RequestParam("commentId") Integer commentId);

}
