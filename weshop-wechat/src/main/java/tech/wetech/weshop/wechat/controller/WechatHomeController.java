package tech.wetech.weshop.wechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.common.controller.BaseController;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.wechat.service.WechatHomeService;
import tech.wetech.weshop.wechat.vo.HomeIndexVO;

/**
 * @author cjbi@outlook.com
 */
@RestController
@RequestMapping("/wechat/home")
public class WechatHomeController extends BaseController {

    @Autowired
    private WechatHomeService wechatHomeService;


    @GetMapping("/index")
    public Result<HomeIndexVO> index() {
        return Result.success(wechatHomeService.index());
    }

}
