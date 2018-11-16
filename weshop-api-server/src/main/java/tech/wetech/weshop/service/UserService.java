package tech.wetech.weshop.service;

import tech.wetech.weshop.domain.User;
import tech.wetech.weshop.query.UserPageQuery;

import java.util.List;

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
    List<User> findUserPage(UserPageQuery userPageParamVO);

    /**
     * 统计用户数
     *
     * @param userPageParamVO
     * @return
     */
    int countUser(UserPageQuery userPageParamVO);

}
