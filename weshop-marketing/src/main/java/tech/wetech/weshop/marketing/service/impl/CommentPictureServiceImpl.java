package tech.wetech.weshop.marketing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.service.BaseService;
import tech.wetech.weshop.marketing.mapper.CommentPictureMapper;
import tech.wetech.weshop.marketing.po.CommentPicture;
import tech.wetech.weshop.marketing.service.CommentPictureService;

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
