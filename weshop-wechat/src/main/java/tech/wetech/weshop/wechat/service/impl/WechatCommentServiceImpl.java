package tech.wetech.weshop.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.user.api.CommentApi;
import tech.wetech.weshop.user.api.CommentPictureApi;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.user.query.CommentQuery;
import tech.wetech.weshop.wechat.service.WechatCommentService;
import tech.wetech.weshop.wechat.vo.CommentCountVO;
import tech.wetech.weshop.wechat.vo.CommentResultVO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WechatCommentServiceImpl implements WechatCommentService {

    @Autowired
    private UserApi userApi;

    @Autowired
    private CommentApi commentApi;

    @Autowired
    private CommentPictureApi commentPictureApi;

    @Override
    public List<CommentResultVO> queryList(CommentQuery commentQuery) {
        List<CommentResultVO> commentResultList = commentApi.queryIfRequirePictureList(commentQuery).getData().stream()
                .map(CommentResultVO::new)
                .collect(Collectors.toList());
        for (CommentResultVO commentResultDTO : commentResultList) {
            commentResultDTO.setPicList(commentPictureApi.queryPicUrlByCommentId(commentResultDTO.getId()).getData());
            User user = Optional.ofNullable(userApi.queryById(commentResultDTO.getUserId()).getData()).orElseGet(() -> new User());
            commentResultDTO.setUserInfo(new CommentResultVO.UserInfoVO(user));
        }
        return commentResultList;
    }

    @Override
    public CommentCountVO countList(CommentQuery commentQuery) {
        Integer hasPicCount = commentApi.countIfRequirePictureList(commentQuery.setRequirePicture(true)).getData();
        Integer allCount = commentApi.countIfRequirePictureList(commentQuery.setRequirePicture(false)).getData();
        return new CommentCountVO(allCount, hasPicCount);
    }
}
