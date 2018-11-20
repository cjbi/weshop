package tech.wetech.weshop.service;

import tech.wetech.weshop.po.UserLevelPO;

import java.util.List;

/**
 * @author cjbi
 */
public interface UserLevelService {

    /**
     * 查询所有
     * @return
     */
    List<UserLevelPO> queryAll();

}
