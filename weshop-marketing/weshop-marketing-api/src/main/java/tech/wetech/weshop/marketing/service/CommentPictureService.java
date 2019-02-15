package tech.wetech.weshop.marketing.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.marketing.po.CommentPicture;
import tech.wetech.weshop.service.IService;

@RequestMapping("/commentPicture")
@FeignClient(value = "weshop-marketing-service")
public interface CommentPictureService extends IService<CommentPicture> {

}
