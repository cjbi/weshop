package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.goods.fallback.ChannelApiFallback;
import tech.wetech.weshop.goods.po.Channel;

@FeignClient(value = "weshop-goods", path = "channel", fallback = ChannelApiFallback.class)
public interface ChannelApi extends Api<Channel> {

}
