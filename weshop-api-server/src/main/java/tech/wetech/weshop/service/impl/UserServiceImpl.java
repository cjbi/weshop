package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.po.UserPO;
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
    public PageInfo<UserPO> queryUserPageInfo(UserPageQuery userPageQuery) {
        Weekend<UserPO> example = Weekend.of(UserPO.class);
        WeekendCriteria<UserPO, Object> criteria = example.weekendCriteria();
        if (userPageQuery.getUsername() != null) {
            criteria.andEqualTo(UserPO::getUsername, userPageQuery.getUsername());
        }
        if (userPageQuery.getMobile() != null) {
            criteria.andEqualTo(UserPO::getMobile, userPageQuery.getMobile());
        }
        if (userPageQuery.getGender() != null) {
            criteria.andEqualTo(UserPO::getGender, userPageQuery.getGender());
        }
        if (userPageQuery.getUserLevelId() != null) {
            criteria.andEqualTo(UserPO::getUserLevelId, userPageQuery.getUserLevelId());
        }
        return PageHelper.startPage(userPageQuery.getPageNum(), userPageQuery.getPageSize())
                .doSelectPageInfo(() -> userMapper.selectByExample(example));
    }

    @Override
    public void createUser(CreateUserFormVO createUserFormVO) {
        UserPO userPO = new UserPO(createUserFormVO);
        userMapper.insertSelective(userPO);
    }

    @Override
    public void updateUser(UpdateUserFormVO updateUserFormVO) {
        UserPO userPO = new UserPO(updateUserFormVO);
        userMapper.updateByPrimaryKeySelective(userPO);
    }

    @Override
    public void deleteUser(Integer... userIds) {
        for (Integer userId : userIds) {
            userMapper.deleteByPrimaryKey(userId);
        }
    }

}
