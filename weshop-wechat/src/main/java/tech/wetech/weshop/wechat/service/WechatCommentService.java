package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.user.query.CommentQuery;
import tech.wetech.weshop.wechat.vo.CommentCountVO;
import tech.wetech.weshop.wechat.vo.CommentResultVO;

import java.util.List;

public interface WechatCommentService {

    List<CommentResultVO> queryList(CommentQuery commentQuery);

    CommentCountVO countList(CommentQuery commentQuery);

}
