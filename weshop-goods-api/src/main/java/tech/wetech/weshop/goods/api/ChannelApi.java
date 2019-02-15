package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.goods.po.Channel;

@RequestMapping("/channel")
@FeignClient(value = "weshop-goods-api")
public interface ChannelApi extends Api<Channel> {

}
