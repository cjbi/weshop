package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.domain.Comment;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/comment")
public class AdminCommentController extends BaseController<Comment> {

}
