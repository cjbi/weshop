package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.domain.Address;
import tech.wetech.weshop.mapper.AddressMapper;
import tech.wetech.weshop.query.AddressPageQuery;
import tech.wetech.weshop.service.AddressService;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class AddressServiceImpl extends BaseService<Address> implements AddressService {

}
