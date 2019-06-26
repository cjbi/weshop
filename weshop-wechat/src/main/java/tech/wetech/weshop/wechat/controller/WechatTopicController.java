package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.query.PageQuery;
import tech.wetech.weshop.common.query.QueryWrapper;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.marketing.api.TopicApi;
import tech.wetech.weshop.marketing.po.Topic;

import java.util.List;

@RequestMapping("/wechat/topic")
@RestController
public class WechatTopicController extends BaseController {

    @Autowired
    private TopicApi topicApi;

    @GetMapping("/related")
    public Result<List<Topic>> relatedTopic() {
        return topicApi.queryListByQueryWrapper(new QueryWrapper(new PageQuery().setPageNum(1).setPageSize(4), null));
    }

    @GetMapping("/list")
    public Result<List<Topic>> list(PageQuery pageQuery, Topic topic) {
        pageQuery.setCountSql(true);
        return topicApi.queryListByQueryWrapper(new QueryWrapper(pageQuery, topic));
    }

    @GetMapping
    public Result<Topic> query(Integer id) {
        return topicApi.queryById(id);
    }

}
