package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.domain.Feedback;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.query.FeedbackPageQuery;
import tech.wetech.weshop.service.FeedbackService;
import tech.wetech.weshop.vo.PageInfoVO;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/feedback")
public class AdminFeedbackController extends BaseController<Feedback> {

}
