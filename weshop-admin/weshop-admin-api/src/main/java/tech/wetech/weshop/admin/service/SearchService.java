package tech.wetech.weshop.admin.service;

import tech.wetech.weshop.admin.dto.SearchIndexDTO;

import java.util.List;

public interface SearchService {

    List<String> helper(String keyword);

    void clearHistory();

    SearchIndexDTO index();

}
