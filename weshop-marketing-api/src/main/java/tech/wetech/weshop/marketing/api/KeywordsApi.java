package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.marketing.fallback.KeywordsApiFallback;
import tech.wetech.weshop.marketing.po.Keywords;

import java.util.List;

@FeignClient(value = "weshop-marketing", path = "keywords", fallback = KeywordsApiFallback.class)
public interface KeywordsApi extends Api<Keywords> {

    List<String> queryByKeyword(String keyword);
}
