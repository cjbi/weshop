package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.KeywordsMapper;
import tech.wetech.weshop.po.Keywords;
import tech.wetech.weshop.po.Order;
import tech.wetech.weshop.query.KeywordsPageQuery;
import tech.wetech.weshop.service.KeywordsService;
import tech.wetech.weshop.vo.CreateKeywordsFormVO;
import tech.wetech.weshop.vo.UpdateKeywordsFormVO;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

@Service
public class KeywordsServiceImpl implements KeywordsService {

    @Autowired
    private KeywordsMapper keywordsMapper;

    @Override
    public PageInfo<Keywords> queryKeywordsPageInfo(KeywordsPageQuery keywordsPageQuery) {
        Weekend<Keywords> example = Weekend.of(Keywords.class);
        WeekendCriteria<Keywords, Object> criteria = example.weekendCriteria();
        if (keywordsPageQuery.getKeyword() != null) {
            criteria.andLike(Keywords::getKeyword, "%" + keywordsPageQuery.getKeyword() + "%");
        }
        if (keywordsPageQuery.getSchemeUrl() != null) {
            criteria.andLike(Keywords::getSchemeUrl, "%" + keywordsPageQuery.getSchemeUrl() + "%");
        }
        return PageHelper.startPage(keywordsPageQuery.getPageNum(), keywordsPageQuery.getPageSize())
                .doSelectPageInfo(() -> keywordsMapper.selectByExample(example));
    }

    @Override
    public void createKeywords(CreateKeywordsFormVO createKeywordsFormVO) {
        Keywords keywords = new Keywords(createKeywordsFormVO);
        keywordsMapper.insertSelective(keywords);
    }

    @Override
    public void updateKeywords(UpdateKeywordsFormVO updateKeywordsFormVO) {
        Keywords keywords = new Keywords(updateKeywordsFormVO);
        keywordsMapper.updateByPrimaryKey(keywords);
    }

    @Override
    public void deleteKeyword(Integer keywordId) {
        keywordsMapper.deleteByPrimaryKey(keywordId);
    }
}
