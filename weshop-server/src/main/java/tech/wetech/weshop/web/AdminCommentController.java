package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Comment;
import tech.wetech.weshop.web.base.BaseCrudController;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/comment")
public class AdminCommentController extends BaseCrudController<Comment> {

}
