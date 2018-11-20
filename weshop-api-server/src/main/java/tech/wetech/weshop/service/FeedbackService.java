package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.Feedback;
import tech.wetech.weshop.query.FeedbackPageQuery;

/**
 * @author cjbi
 */
public interface FeedbackService {


    PageInfo<Feedback> queryFeedbackPageInfo(FeedbackPageQuery feedbackPageQuery);

}
