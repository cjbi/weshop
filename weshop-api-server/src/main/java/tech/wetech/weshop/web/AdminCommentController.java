package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.domain.Comment;
import tech.wetech.weshop.query.CommentPageQuery;
import tech.wetech.weshop.service.CommentService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.PageInfoVO;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/comment")
public class AdminCommentController extends BaseController<Comment> {

}
