package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.CommentMapper;
import tech.wetech.weshop.po.Comment;
import tech.wetech.weshop.query.CommentPageQuery;
import tech.wetech.weshop.service.CommentService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public PageInfo<Comment> queryCommentPageInfo(CommentPageQuery commentPageQuery) {
        Weekend<Comment> example = Weekend.of(Comment.class);
        WeekendCriteria<Comment, Object> criteria = example.weekendCriteria();
        if (commentPageQuery.getUserId() != null) {
            criteria.andEqualTo(Comment::getUserId, commentPageQuery.getUserId());
        }
        if (commentPageQuery.getValueId() != null) {
            criteria.andEqualTo(Comment::getValueId, commentPageQuery.getValueId());
        }
        return PageHelper.startPage(commentPageQuery.getPageNum(), commentPageQuery.getPageSize())
                .doSelectPageInfo(() -> commentMapper.selectAll());
    }

    @Override
    public void deleteComment(Integer commentId) {
        commentMapper.deleteByPrimaryKey(commentId);
    }
}
