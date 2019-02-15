package tech.wetech.weshop.goods.client;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.goods.fallback.CommentClientFallBack;
import tech.wetech.weshop.marketing.service.CommentPictureService;

@FeignClient(value = "weshop-marketing-service")
public interface CommentPictureClient extends CommentPictureService {

}
