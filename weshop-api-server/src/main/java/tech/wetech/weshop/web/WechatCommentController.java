package tech.wetech.weshop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Comment;

@RestController
@RequestMapping("/wechat/comment")
public class WechatCommentController extends BaseController<Comment> {

}
