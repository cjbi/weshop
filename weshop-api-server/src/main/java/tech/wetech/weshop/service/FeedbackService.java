package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.FeedbackPO;
import tech.wetech.weshop.query.FeedbackPageQuery;

/**
 * @author cjbi
 */
public interface FeedbackService {


    PageInfo<FeedbackPO> queryFeedbackPageInfo(FeedbackPageQuery feedbackPageQuery);

}
