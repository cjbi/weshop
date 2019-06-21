package tech.wetech.weshop.goods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.goods.api.ChannelApi;
import tech.wetech.weshop.goods.po.Channel;

@RestController
@RequestMapping("/channel")
public class ChannelController extends BaseApi<Channel> implements ChannelApi {

}
