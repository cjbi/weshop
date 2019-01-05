package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.CommentMapper;
import tech.wetech.weshop.mapper.CommentPictureMapper;
import tech.wetech.weshop.mapper.UserMapper;
import tech.wetech.weshop.po.Comment;
import tech.wetech.weshop.po.User;
import tech.wetech.weshop.query.CommentQuery;
import tech.wetech.weshop.service.CommentService;
import tech.wetech.weshop.vo.CommentResultVO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@Service
public class CommentServiceImpl extends BaseService<Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private CommentPictureMapper commentPictureMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<CommentResultVO> queryList(CommentQuery commentQuery) {
        PageHelper.startPage(commentQuery).setCount(false);
        List<CommentResultVO> commentResultList = commentMapper.selectIfRequirePictureList(commentQuery).stream()
                .map(CommentResultVO::new)
                .collect(Collectors.toList());
        for (CommentResultVO commentResultVO : commentResultList) {
            commentResultVO.setPicList(commentPictureMapper.selectPicUrlByCommentId(commentResultVO.getId()));
            User user = Optional.ofNullable(userMapper.selectByPrimaryKey(commentResultVO.getUserId())).orElseGet(() -> new User());
            commentResultVO.setUserInfo(new CommentResultVO.UserInfoVO(user));
        }
        return commentResultList;
    }

    @Override
    public long countList(CommentQuery commentQuery) {
        return PageHelper.startPage(commentQuery)
                .setCount(true)
                .doCount(() -> commentMapper.selectIfRequirePictureList(commentQuery));
    }
}
