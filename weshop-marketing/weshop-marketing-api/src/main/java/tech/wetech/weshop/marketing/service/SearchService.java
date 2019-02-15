package tech.wetech.weshop.marketing.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.marketing.dto.SearchIndexDTO;

import java.util.List;

@RequestMapping("/search")
@FeignClient(value = "weshop-marketing-service")
public interface SearchService {

    @GetMapping("/helper")
    List<String> helper(String keyword);

    @GetMapping("/clearHistory")
    void clearHistory();

    @GetMapping("/index")
    SearchIndexDTO index();

}
