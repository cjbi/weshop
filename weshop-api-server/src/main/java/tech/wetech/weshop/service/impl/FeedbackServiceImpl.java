package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.FeedbackMapper;
import tech.wetech.weshop.po.FeedbackPO;
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
    public PageInfo<FeedbackPO> queryFeedbackPageInfo(FeedbackPageQuery feedbackPageQuery) {
        Weekend<FeedbackPO> example = Weekend.of(FeedbackPO.class);
        WeekendCriteria<FeedbackPO, Object> criteria = example.weekendCriteria();
        if (feedbackPageQuery.getUserId() != null) {
            criteria.andEqualTo(FeedbackPO::getUserId, feedbackPageQuery.getUserId());
        }
        if (feedbackPageQuery.getMsgId() != null) {
            criteria.andEqualTo(FeedbackPO::getMsgId, feedbackPageQuery.getMsgId());
        }
        return PageHelper.startPage(feedbackPageQuery.getPageNum(), feedbackPageQuery.getPageSize())
                .doSelectPageInfo(() -> feedbackMapper.selectByExample(example));
    }
}
