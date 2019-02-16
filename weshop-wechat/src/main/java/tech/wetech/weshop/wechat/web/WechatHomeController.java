package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.marketing.api.HomeApi;
import tech.wetech.weshop.marketing.dto.HomeIndexDTO;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.web.BaseController;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/wechat/home")
public class WechatHomeController extends BaseController {

    @Autowired
    private HomeApi homeApi;


    @GetMapping("/index")
    public Result<HomeIndexDTO> index() {
        return homeApi.index();
    }

}
