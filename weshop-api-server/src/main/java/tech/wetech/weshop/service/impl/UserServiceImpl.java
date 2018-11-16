package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.domain.User;
import tech.wetech.weshop.mapper.UserMapper;
import tech.wetech.weshop.query.UserPageQuery;
import tech.wetech.weshop.service.UserService;
import tk.mybatis.mapper.util.StringUtil;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Collections;
import java.util.List;

/**
 * @author cjbi
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUserPage(UserPageQuery userPageQuery) {
        PageHelper.startPage(userPageQuery.getPageNum(), userPageQuery.getPageSize());
        Weekend<User> example = Weekend.of(User.class);
        WeekendCriteria<User, Object> criteria = example.weekendCriteria();

        if (StringUtil.isNotEmpty(userPageQuery.getUsername())) {
            criteria.andEqualTo(User::getUsername, userPageQuery.getUsername());
        }
        if (StringUtil.isNotEmpty(userPageQuery.getMobile())) {
            criteria.andEqualTo(User::getMobile, userPageQuery.getMobile());
        }

        List<User> list = userMapper.selectByExample(example);
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        return list;
    }

    @Override
    public int countUser(UserPageQuery userPageQuery) {
        Weekend<User> example = Weekend.of(User.class);
        WeekendCriteria<User, Object> criteria = example.weekendCriteria();

        if (StringUtil.isNotEmpty(userPageQuery.getUsername())) {
            criteria.andEqualTo(User::getUsername, userPageQuery.getUsername());
        }
        if (StringUtil.isNotEmpty(userPageQuery.getMobile())) {
            criteria.andEqualTo(User::getMobile, userPageQuery.getMobile());
        }

        return userMapper.selectCountByExample(example);
    }
}
