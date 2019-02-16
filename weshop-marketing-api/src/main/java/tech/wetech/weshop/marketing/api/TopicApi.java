package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.marketing.fallback.TopicApiFallback;
import tech.wetech.weshop.marketing.po.Topic;

@FeignClient(value = "weshop-marketing", path = "topic", fallback = TopicApiFallback.class)
public interface TopicApi extends Api<Topic> {
}
