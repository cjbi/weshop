package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.marketing.api.TopicApi;
import tech.wetech.weshop.marketing.po.Topic;

/**
 * @author cjbi
 */
@Component
public class TopicApiFallback extends ApiFallback<Topic> implements TopicApi {
}
