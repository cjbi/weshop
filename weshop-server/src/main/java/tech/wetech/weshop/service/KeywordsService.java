package tech.wetech.weshop.service;

import tech.wetech.weshop.po.Keywords;

import java.util.List;

/**
 * @author cjbi
 */
public interface KeywordsService extends IService<Keywords> {

    List<String> helper(String keyword);

}
