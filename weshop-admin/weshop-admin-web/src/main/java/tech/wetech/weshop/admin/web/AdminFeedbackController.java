package tech.wetech.weshop.admin.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Feedback;
import tech.wetech.weshop.web.BaseCrudController;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/admin/feedback")
public class AdminFeedbackController extends BaseCrudController<Feedback> {

}
