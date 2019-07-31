package tech.wetech.weshop.user.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.user.api.AdApi;
import tech.wetech.weshop.user.po.Ad;

@Component
public class AdApiFallback extends ApiFallback<Ad> implements AdApi {
}
