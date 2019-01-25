package tech.wetech.weshop.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.wechat.service.HomeService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.wechat.dto.HomeIndexDTO;
import tech.wetech.weshop.web.BaseController;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/wechat/home")
public class WechatHomeController extends BaseController {

    @Autowired
    private HomeService homeService;


    @GetMapping("/index")
    public Result<HomeIndexDTO> index() {
        return Result.success(homeService.index());
    }

}
