package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Feedback;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/feedback")
public class AdminFeedbackCrudController extends BaseCrudController<Feedback> {

}
