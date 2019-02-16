package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.po.Channel;

@FeignClient(value = "weshop-goods", path = "channel")
public interface ChannelApi extends Api<Channel> {

}
