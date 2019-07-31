package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.user.fallback.TopicApiFallback;
import tech.wetech.weshop.user.po.Topic;

@FeignClient(value = "weshop-user", path = "topic", fallback = TopicApiFallback.class)
public interface TopicApi extends Api<Topic> {
}
