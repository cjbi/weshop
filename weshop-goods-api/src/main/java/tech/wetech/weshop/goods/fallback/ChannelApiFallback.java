package tech.wetech.weshop.goods.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.goods.api.ChannelApi;
import tech.wetech.weshop.goods.po.Channel;

@Component
public class ChannelApiFallback extends ApiFallback<Channel> implements ChannelApi {

}
