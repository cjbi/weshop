package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tech.wetech.weshop.marketing.dto.SearchIndexDTO;
import tech.wetech.weshop.marketing.fallback.SearchApiFallback;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@FeignClient(value = "weshop-marketing", path = "search", fallback = SearchApiFallback.class)
public interface SearchApi {

    @GetMapping("/helper")
    Result<List<String>> helper(String keyword);

    @GetMapping("/clearHistory")
    Result clearHistory();

    @GetMapping("/index")
    Result<SearchIndexDTO> index();

}
