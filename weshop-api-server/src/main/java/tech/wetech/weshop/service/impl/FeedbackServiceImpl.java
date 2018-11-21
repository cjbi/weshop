package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.FeedbackMapper;
import tech.wetech.weshop.po.Feedback;
import tech.wetech.weshop.query.FeedbackPageQuery;
import tech.wetech.weshop.service.FeedbackService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public PageInfo<Feedback> queryFeedbackPageInfo(FeedbackPageQuery feedbackPageQuery) {
        Weekend<Feedback> example = Weekend.of(Feedback.class);
        WeekendCriteria<Feedback, Object> criteria = example.weekendCriteria();
        if (feedbackPageQuery.getUserId() != null) {
            criteria.andEqualTo(Feedback::getUserId, feedbackPageQuery.getUserId());
        }
        if (feedbackPageQuery.getMsgId() != null) {
            criteria.andEqualTo(Feedback::getMsgId, feedbackPageQuery.getMsgId());
        }
        return PageHelper.startPage(feedbackPageQuery.getPageNum(), feedbackPageQuery.getPageSize())
                .doSelectPageInfo(() -> feedbackMapper.selectByExample(example));
    }
}
