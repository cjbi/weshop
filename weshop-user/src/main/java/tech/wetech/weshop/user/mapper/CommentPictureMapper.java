package tech.wetech.weshop.user.mapper;

import tech.wetech.weshop.common.utils.MyMapper;
import tech.wetech.weshop.user.po.CommentPicture;

import java.util.List;

public interface CommentPictureMapper extends MyMapper<CommentPicture> {

    List<String> selectPicUrlByCommentId(Integer commentId);

}
