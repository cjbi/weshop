package tech.wetech.weshop.goods.client;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.marketing.service.CommentService;

@FeignClient(value = "weshop-marketing-service")
public interface CommentClient extends CommentService {

}
