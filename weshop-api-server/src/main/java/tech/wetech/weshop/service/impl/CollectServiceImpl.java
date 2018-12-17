package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.CollectMapper;
import tech.wetech.weshop.domain.Collect;
import tech.wetech.weshop.query.CollectPageQuery;
import tech.wetech.weshop.service.CollectService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class CollectServiceImpl extends BaseService<Collect> implements CollectService {

}
