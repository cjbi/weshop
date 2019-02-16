package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.marketing.po.CommentPicture;

@FeignClient(value = "weshop-marketing", path = "commentPicture")
public interface CommentPictureApi extends Api<CommentPicture> {
}
