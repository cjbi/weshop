package tech.wetech.weshop.admin.web;

import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Comment;
import tech.wetech.weshop.web.BaseCrudController;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/admin/comment")
public class AdminCommentController extends BaseCrudController<Comment> {

}
