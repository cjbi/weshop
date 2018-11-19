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
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public PageInfo<Address> queryAddressPageInfo(AddressPageQuery addressPageQuery) {
        Weekend<Address> example = Weekend.of(Address.class);
        WeekendCriteria<Address, Object> criteria = example.weekendCriteria();
        if (addressPageQuery.getUserId() != null) {
            criteria.andEqualTo(Address::getUserId, addressPageQuery.getUserId());
        }
        if (addressPageQuery.getName() != null) {
            criteria.andEqualTo(Address::getName, addressPageQuery.getName());
        }
        if (addressPageQuery.getMobile() != null) {
            criteria.andEqualTo(Address::getMobile, addressPageQuery.getMobile());
        }
        return PageHelper.startPage(addressPageQuery.getPageNum(), addressPageQuery.getPageSize())
                .doSelectPageInfo(() -> addressMapper.selectByExample(example));
    }
}
