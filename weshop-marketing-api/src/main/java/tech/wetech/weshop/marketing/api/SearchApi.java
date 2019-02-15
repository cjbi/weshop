package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.marketing.dto.SearchIndexDTO;

import java.util.List;

@FeignClient("weshop-topic-service")
@RequestMapping("/search")
public interface SearchApi {

    @GetMapping("/helper")
    List<String> helper(String keyword);

    @GetMapping("/clearHistory")
    void clearHistory();

    @GetMapping("/index")
    SearchIndexDTO index();

}
