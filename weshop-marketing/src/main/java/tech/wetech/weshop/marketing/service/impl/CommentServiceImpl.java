package tech.wetech.weshop.marketing.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.marketing.dto.CommentCountDTO;
import tech.wetech.weshop.marketing.dto.CommentResultDTO;
import tech.wetech.weshop.marketing.mapper.CommentMapper;
import tech.wetech.weshop.marketing.mapper.CommentPictureMapper;
import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.query.CommentQuery;
import tech.wetech.weshop.marketing.service.CommentService;
import tech.wetech.weshop.service.BaseService;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.po.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author cjbi@outlook.com
 */
@Service
public class CommentServiceImpl extends BaseService<Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private CommentPictureMapper commentPictureMapper;

    @Autowired
    private UserApi userApi;

    @Override
    public List<CommentResultDTO> queryList(CommentQuery commentQuery) {
        PageHelper.startPage(commentQuery).setCount(false);
        List<CommentResultDTO> commentResultList = commentMapper.selectIfRequirePictureList(commentQuery).stream()
                .map(CommentResultDTO::new)
                .collect(Collectors.toList());
        for (CommentResultDTO commentResultDTO : commentResultList) {
            commentResultDTO.setPicList(commentPictureMapper.selectPicUrlByCommentId(commentResultDTO.getId()));
            User user = Optional.ofNullable(userApi.queryById(commentResultDTO.getUserId()).getData()).orElseGet(() -> new User());
            commentResultDTO.setUserInfo(new CommentResultDTO.UserInfoVO(user));
        }
        return commentResultList;
    }

    @Override
    public CommentCountDTO countList(CommentQuery commentQuery) {
        long hasPicCount = PageHelper.startPage(commentQuery)
                .setCount(true)
                .doCount(() -> commentMapper.selectIfRequirePictureList(commentQuery.setRequirePicture(true)));
        long allCount = PageHelper.startPage(commentQuery)
                .setCount(true)
                .doCount(() -> commentMapper.selectIfRequirePictureList(commentQuery.setRequirePicture(false)));
        return new CommentCountDTO(allCount, hasPicCount);
    }
}
