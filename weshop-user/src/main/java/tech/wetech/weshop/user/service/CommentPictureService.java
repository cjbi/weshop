package tech.wetech.weshop.user.service;

import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.user.po.CommentPicture;

import java.util.List;

public interface CommentPictureService extends IService<CommentPicture> {

    List<String> queryPicUrlByCommentId(Integer commentId);

}
