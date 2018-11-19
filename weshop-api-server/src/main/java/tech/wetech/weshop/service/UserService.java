package tech.wetech.weshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.domain.User;
import tech.wetech.weshop.query.UserPageQuery;
import tech.wetech.weshop.vo.CreateUserFormVO;
import tech.wetech.weshop.vo.UpdateUserFormVO;

/**
 * @author cjbi
 */
public interface UserService {

    /**
     * 分页查询用户
     *
     * @param userPageParamVO
     * @return
     */
    PageInfo<User> findUserPageInfo(UserPageQuery userPageParamVO);

    /**
     * 创建用户
     * @param createUserFormVO
     */
    void createUser(CreateUserFormVO createUserFormVO);

    /**
     * 修改用户
     * @param updateUserFormVO
     */
    void updateUser(UpdateUserFormVO updateUserFormVO);

    void deleteUser(Integer... userId);

}
