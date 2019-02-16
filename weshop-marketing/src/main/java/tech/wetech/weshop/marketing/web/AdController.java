package tech.wetech.weshop.marketing.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.api.BaseApi;
import tech.wetech.weshop.marketing.api.AdApi;
import tech.wetech.weshop.marketing.po.Ad;

@RestController
@RequestMapping("/ad")
public class AdController extends BaseApi<Ad> implements AdApi {

}
