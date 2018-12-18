package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.service.AdService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.IndexVO;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/wechat/home")
public class WechatHomeController {

    @Autowired
    private AdService adService;

    @GetMapping("/index")
    public Result<IndexVO> index() {

        return Result.success();
    }

}
