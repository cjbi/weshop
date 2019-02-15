package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.marketing.po.Topic;

@RequestMapping("/topic")
@FeignClient("weshop-marketing")
public interface TopicApi extends Api<Topic> {
}
