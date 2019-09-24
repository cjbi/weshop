package tech.wetech.weshop.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.utils.ResultWrapper;
import tech.wetech.weshop.user.fallback.KeywordsApiFallback;
import tech.wetech.weshop.user.po.Keywords;

import java.util.List;

@FeignClient(value = "weshop-user", path = "keywords", fallback = KeywordsApiFallback.class)
public interface KeywordsApi extends Api<Keywords> {

    @GetMapping("/queryByKeyword")
    ResultWrapper<List<String>> queryByKeyword(@RequestParam("keyword") String keyword);
}
