package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.po.User;
import tech.wetech.weshop.mapper.UserMapper;
import tech.wetech.weshop.query.UserPageQuery;
import tech.wetech.weshop.service.UserService;
import tech.wetech.weshop.vo.CreateUserFormVO;
import tech.wetech.weshop.vo.UpdateUserFormVO;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> queryUserPageInfo(UserPageQuery userPageQuery) {
        Weekend<User> example = Weekend.of(User.class);
        WeekendCriteria<User, Object> criteria = example.weekendCriteria();
        if (userPageQuery.getUsername() != null) {
            criteria.andEqualTo(User::getUsername, userPageQuery.getUsername());
        }
        if (userPageQuery.getMobile() != null) {
            criteria.andEqualTo(User::getMobile, userPageQuery.getMobile());
        }
        if (userPageQuery.getGender() != null) {
            criteria.andEqualTo(User::getGender, userPageQuery.getGender());
        }
        if (userPageQuery.getUserLevelId() != null) {
            criteria.andEqualTo(User::getUserLevelId, userPageQuery.getUserLevelId());
        }
        return PageHelper.startPage(userPageQuery.getPageNum(), userPageQuery.getPageSize())
                .doSelectPageInfo(() -> userMapper.selectByExample(example));
    }

    @Override
    public void createUser(CreateUserFormVO createUserFormVO) {
        User user = new User(createUserFormVO);
        userMapper.insertSelective(user);
    }

    @Override
    public void updateUser(UpdateUserFormVO updateUserFormVO) {
        User user = new User(updateUserFormVO);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

}
