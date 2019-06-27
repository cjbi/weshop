package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.marketing.fallback.KeywordsApiFallback;
import tech.wetech.weshop.marketing.po.Keywords;

import java.util.List;

@FeignClient(value = "weshop-marketing", path = "keywords", fallback = KeywordsApiFallback.class)
public interface KeywordsApi extends Api<Keywords> {

    @GetMapping("/queryByKeyword")
    List<String> queryByKeyword(@RequestParam("keyword") String keyword);
}
