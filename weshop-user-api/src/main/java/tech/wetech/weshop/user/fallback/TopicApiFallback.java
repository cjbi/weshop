package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.user.api.TopicApi;
import tech.wetech.weshop.user.po.Topic;

/**
 * @author cjbi
 */
@Component
public class TopicApiFallback extends ApiFallback<Topic> implements TopicApi {
}
