package tech.wetech.weshop.marketing.service;

import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.marketing.po.Keywords;

import java.util.List;

public interface KeywordsService extends IService<Keywords> {

    List<String> queryByKeyword(String keyword);
}
