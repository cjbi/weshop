package tech.wetech.weshop.marketing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.service.BaseService;
import tech.wetech.weshop.marketing.mapper.KeywordsMapper;
import tech.wetech.weshop.marketing.po.Keywords;
import tech.wetech.weshop.marketing.service.KeywordsService;

import java.util.List;

@Service
public class KeywordsServiceImpl extends BaseService<Keywords> implements KeywordsService {

    @Autowired
    private KeywordsMapper keywordsMapper;

    @Override
    public List<String> queryByKeyword(String keyword) {
        return keywordsMapper.selectByKeywordLike(keyword);
    }
}
