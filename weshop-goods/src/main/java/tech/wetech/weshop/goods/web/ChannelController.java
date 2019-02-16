package tech.wetech.weshop.goods.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.goods.api.ChannelApi;
import tech.wetech.weshop.goods.po.Channel;

@RestController
@RequestMapping("/channel")
public class ChannelController extends BaseApi<Channel> implements ChannelApi {

}
