package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.GoodsMapper;
import tech.wetech.weshop.domain.Goods;
import tech.wetech.weshop.query.GoodsPageQuery;
import tech.wetech.weshop.service.GoodsService;
import tech.wetech.weshop.vo.CreateGoodsFormVO;
import tech.wetech.weshop.vo.UpdateGoodsFormVO;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

@Service
public class GoodsServiceImpl extends BaseService<Goods> implements GoodsService {

}
