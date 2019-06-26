package tech.wetech.weshop.marketing.service;

import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.marketing.po.CommentPicture;

import java.util.List;

public interface CommentPictureService extends IService<CommentPicture> {

    List<String> queryPicUrlByCommentId(Integer commentId);

}
