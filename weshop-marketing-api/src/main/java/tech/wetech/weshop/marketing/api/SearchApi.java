package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.marketing.dto.SearchIndexDTO;

import java.util.List;

@FeignClient(value = "weshop-marketing", path = "search")
public interface SearchApi {

    @RequestMapping(value = "/helper", method = RequestMethod.GET)
    List<String> helper(String keyword);

    @RequestMapping(value = "/clearHistory", method = RequestMethod.GET)
    void clearHistory();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    SearchIndexDTO index();

}
