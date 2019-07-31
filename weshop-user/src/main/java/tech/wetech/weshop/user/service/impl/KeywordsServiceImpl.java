package tech.wetech.weshop.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.service.BaseService;
import tech.wetech.weshop.user.mapper.KeywordsMapper;
import tech.wetech.weshop.user.po.Keywords;
import tech.wetech.weshop.user.service.KeywordsService;

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
