package tech.wetech.weshop.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.api.BaseApi;
import tech.wetech.weshop.user.api.AdApi;
import tech.wetech.weshop.user.po.Ad;

@RestController
@RequestMapping("/ad")
public class AdController extends BaseApi<Ad> implements AdApi {

}
