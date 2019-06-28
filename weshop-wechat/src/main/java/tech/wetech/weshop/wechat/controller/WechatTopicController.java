package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.query.Criteria;
import tech.wetech.weshop.common.query.PageQuery;
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
        return topicApi.queryByCriteria(Criteria.of(Topic.class).page(1,4));
    }

    @GetMapping("/list")
    public Result<List<Topic>> list(PageQuery pageQuery, Topic topic) {
        //FIXME 此处需要条件查询
        Criteria<Topic, Object> criteria = Criteria.of(Topic.class).page(pageQuery.getPageNum(), pageQuery.getPageSize());
        return topicApi.queryByCriteria(criteria)
                .addExtra("total", topicApi.countByCriteria(criteria));
    }

    @GetMapping
    public Result<Topic> query(Integer id) {
        return topicApi.queryById(id);
    }

}
