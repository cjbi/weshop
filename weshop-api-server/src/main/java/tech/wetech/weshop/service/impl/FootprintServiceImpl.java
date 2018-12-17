package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.FootprintMapper;
import tech.wetech.weshop.domain.Footprint;
import tech.wetech.weshop.query.FootprintPageQuery;
import tech.wetech.weshop.service.FootprintService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class FootprintServiceImpl extends BaseService<Footprint> implements FootprintService {

}
