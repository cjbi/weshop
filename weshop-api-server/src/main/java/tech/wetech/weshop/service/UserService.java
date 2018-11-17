package tech.wetech.weshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.domain.User;
import tech.wetech.weshop.query.UserPageQuery;

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

}
