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

    @Autowired
    private KeywordsMapper keywordsMapper;

    @Override
    public List<String> helper(String keyword) {
        Weekend<Keywords> example = Weekend.of(Keywords.class);
        example.selectProperties(Reflections.fnToFieldName(Keywords::getKeyword));
        WeekendCriteria<Keywords, Object> criteria = example.weekendCriteria();
        criteria.andLike(Keywords::getKeyword, "%" + keyword + "%");

        return PageHelper.startPage(1, 10).doSelectPage(() ->
                keywordsMapper.selectByExample(example).stream()
                        .map(Keywords::getKeyword)
                        .collect(Collectors.toList())
        );
    }
}
