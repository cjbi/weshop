package tech.wetech.weshop.marketing.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.marketing.api.AdApi;
import tech.wetech.weshop.marketing.po.Ad;

@Component
public class AdApiFallback extends ApiFallback<Ad> implements AdApi {
}
