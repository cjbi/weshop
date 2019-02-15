package tech.wetech.weshop.marketing.service;

import tech.wetech.weshop.marketing.dto.SearchIndexDTO;

import java.util.List;

public interface SearchService {

    List<String> helper(String keyword);

    void clearHistory();

    SearchIndexDTO index();

}
