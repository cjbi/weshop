package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.KeywordsMapper;
import tech.wetech.weshop.domain.Keywords;
import tech.wetech.weshop.query.KeywordsPageQuery;
import tech.wetech.weshop.service.KeywordsService;
import tech.wetech.weshop.vo.CreateKeywordsFormVO;
import tech.wetech.weshop.vo.UpdateKeywordsFormVO;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

@Service
public class KeywordsServiceImpl extends BaseService<Keywords> implements KeywordsService {

}
