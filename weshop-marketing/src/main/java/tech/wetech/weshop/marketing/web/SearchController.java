package tech.wetech.weshop.marketing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.marketing.api.SearchApi;
import tech.wetech.weshop.marketing.dto.SearchIndexDTO;
import tech.wetech.weshop.marketing.service.SearchService;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController implements SearchApi {

    @Autowired
    private SearchService searchService;

    @Override
    public List<String> helper(String keyword) {
        return searchService.helper(keyword);
    }

    @Override
    public void clearHistory() {
        searchService.clearHistory();
    }

    @Override
    public SearchIndexDTO index() {
        return searchService.index();
    }
}
