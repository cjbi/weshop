package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.domain.UserLevel;
import tech.wetech.weshop.mapper.UserLevelMapper;
import tech.wetech.weshop.service.UserLevelService;

import java.util.List;

/**
 * @author cjbi
 */
@Service
public class UserLevelServiceImpl implements UserLevelService {

    @Autowired
    private UserLevelMapper userLevelMapper;


    @Override
    public List<UserLevel> queryAll() {
        return userLevelMapper.selectAll();
    }
}
