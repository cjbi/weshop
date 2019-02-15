package tech.wetech.weshop.marketing.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.marketing.po.Topic;
import tech.wetech.weshop.service.IService;

@RequestMapping("/topic")
@FeignClient(value = "weshop-marketing-service")
public interface TopicService extends IService<Topic> {

}
