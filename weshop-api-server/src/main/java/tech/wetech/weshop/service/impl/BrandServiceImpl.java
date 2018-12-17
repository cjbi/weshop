package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.BrandMapper;
import tech.wetech.weshop.domain.Brand;
import tech.wetech.weshop.query.BrandPageQuery;
import tech.wetech.weshop.service.BrandService;
import tech.wetech.weshop.vo.CreateBrandFormVO;
import tech.wetech.weshop.vo.UpdateBrandFormVO;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class BrandServiceImpl extends BaseService<Brand> implements BrandService {

}
