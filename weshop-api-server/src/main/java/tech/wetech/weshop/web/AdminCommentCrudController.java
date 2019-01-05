package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.po.Comment;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/comment")
public class AdminCommentCrudController extends BaseCrudController<Comment> {

}
