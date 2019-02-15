package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.marketing.po.CommentPicture;

@FeignClient("weshop-marketing")
@RequestMapping("/commentPicture")
public interface CommentPictureApi extends Api<CommentPicture> {
}
