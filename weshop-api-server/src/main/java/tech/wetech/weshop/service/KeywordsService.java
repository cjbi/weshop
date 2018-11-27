package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.Keywords;
import tech.wetech.weshop.query.KeywordsPageQuery;
import tech.wetech.weshop.vo.CreateKeywordsFormVO;
import tech.wetech.weshop.vo.UpdateKeywordsFormVO;

/**
 * @author cjbi
 */
public interface KeywordsService {

    PageInfo<Keywords> queryKeywordsPageInfo(KeywordsPageQuery keywordsPageQuery);

    void createKeywords(CreateKeywordsFormVO createKeywordsFormVO);

    void updateKeywords(UpdateKeywordsFormVO updateKeywordsFormVO);

    void deleteKeyword(Integer keywordId);

}
