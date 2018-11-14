package tech.wetech.weshop.modules.example.service;

import tech.wetech.weshop.modules.example.vo.UserCreateVO;
import tech.wetech.weshop.modules.example.vo.UserPageParamVO;
import tech.wetech.weshop.modules.example.vo.UserResultVO;
import tech.wetech.weshop.modules.example.vo.UserUpdateVO;

import java.util.List;

/**
 * @author cjbi
 */
public interface UserService {

    /**
     * 分页查询用户
     * @param userPageParamVO
     * @return
     */
    List<UserResultVO> findUserPage(UserPageParamVO userPageParamVO);

    void createUser(UserCreateVO userCreateVO);

    void updateUser(UserUpdateVO userUpdateVO);

    void deleteUser(Long userId);

    int countUser(UserPageParamVO userPageParamVO);

}
