package tech.wetech.weshop.modules.example.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.modules.example.mapper.UserMapper;
import tech.wetech.weshop.modules.example.po.User;
import tech.wetech.weshop.modules.example.vo.UserCreateVO;
import tech.wetech.weshop.modules.example.vo.UserPageParamVO;
import tech.wetech.weshop.modules.example.vo.UserResultVO;
import tech.wetech.weshop.modules.example.vo.UserUpdateVO;
import tk.mybatis.mapper.util.StringUtil;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cjbi
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserResultVO> findUserPage(UserPageParamVO userPageParamVO) {
        PageHelper.startPage(userPageParamVO.getPageNum(), userPageParamVO.getPageSize());
        Weekend<User> example = Weekend.of(User.class);
        WeekendCriteria<User, Object> criteria = example.weekendCriteria();
        if (StringUtil.isNotEmpty(userPageParamVO.getUsername())) {
            criteria.andLike(User::getUsername, "%" + userPageParamVO.getUsername() + "%");
        }
        List<User> list = userMapper.selectByExample(example);
        List<UserResultVO> dataList = new ArrayList<>();
        for (User user : list) {
            dataList.add(new UserResultVO(user));
        }
        return dataList;
    }

    @Override
    public void createUser(UserCreateVO userCreateVO) {
        userMapper.insertSelective(new User(userCreateVO));

    }

    @Override
    public void updateUser(UserUpdateVO userUpdateVO) {
        userMapper.updateByPrimaryKeySelective(new User(userUpdateVO));
    }

    @Override
    public void deleteUser(Long userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int countUser(UserPageParamVO userPageParamVO) {
        Weekend<User> example = Weekend.of(User.class);
        WeekendCriteria<User, Object> criteria = example.weekendCriteria();
        if (StringUtil.isNotEmpty(userPageParamVO.getUsername())) {
            criteria.andLike(User::getUsername, "%" + userPageParamVO.getUsername() + "%");
        }
        return userMapper.selectCountByExample(example);
    }
}
