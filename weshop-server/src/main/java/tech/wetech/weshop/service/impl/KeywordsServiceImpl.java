package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.KeywordsMapper;
import tech.wetech.weshop.po.Keywords;
import tech.wetech.weshop.service.KeywordsService;
import tech.wetech.weshop.utils.Reflections;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeywordsServiceImpl extends BaseService<Keywords> implements KeywordsService {

}
