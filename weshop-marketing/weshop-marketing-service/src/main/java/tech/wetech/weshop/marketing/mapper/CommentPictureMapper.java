package tech.wetech.weshop.marketing.mapper;

import tech.wetech.weshop.po.CommentPicture;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface CommentPictureMapper extends MyMapper<CommentPicture> {

    List<String> selectPicUrlByCommentId(Integer commentId);

}