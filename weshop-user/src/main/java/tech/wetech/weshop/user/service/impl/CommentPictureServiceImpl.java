package tech.wetech.weshop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.service.BaseService;
import tech.wetech.weshop.user.mapper.CommentPictureMapper;
import tech.wetech.weshop.user.po.CommentPicture;
import tech.wetech.weshop.user.service.CommentPictureService;

import java.util.List;

@Service
public class CommentPictureServiceImpl extends BaseService<CommentPicture> implements CommentPictureService {

    @Autowired
    private CommentPictureMapper commentPictureMapper;

    @Override
    public List<String> queryPicUrlByCommentId(Integer commentId) {
        return commentPictureMapper.selectPicUrlByCommentId(commentId);
    }
}
