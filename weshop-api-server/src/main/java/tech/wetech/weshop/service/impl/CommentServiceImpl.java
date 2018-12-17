package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.CommentMapper;
import tech.wetech.weshop.domain.Comment;
import tech.wetech.weshop.query.CommentPageQuery;
import tech.wetech.weshop.service.CommentService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class CommentServiceImpl extends BaseService<Comment> implements CommentService {

}
