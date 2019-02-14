package tech.wetech.weshop.marketing.mapper;

import tech.wetech.weshop.po.Keywords;
import tech.wetech.weshop.utils.MyMapper;

import java.util.List;

public interface KeywordsMapper extends MyMapper<Keywords> {

    List<String> selectByKeywordLike(String keyword);
}