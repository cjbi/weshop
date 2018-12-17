package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.FeedbackMapper;
import tech.wetech.weshop.domain.Feedback;
import tech.wetech.weshop.query.FeedbackPageQuery;
import tech.wetech.weshop.service.FeedbackService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class FeedbackServiceImpl extends BaseService<Feedback> implements FeedbackService {

}
