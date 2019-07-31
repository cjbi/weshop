package tech.wetech.weshop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.user.api.TopicApi;
import tech.wetech.weshop.user.po.Topic;

@RestController
@RequestMapping("/topic")
public class TopicController extends BaseApi<Topic> implements TopicApi {
}
