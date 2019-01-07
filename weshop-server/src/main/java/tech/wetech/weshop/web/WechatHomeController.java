package tech.wetech.weshop.web;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.*;
import tech.wetech.weshop.service.*;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.HomeCategoryVO;
import tech.wetech.weshop.vo.HomeIndexVO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/wechat/home")
public class WechatHomeController {

    @Autowired
    private HomeService homeService;


    @GetMapping("/index")
    public Result<HomeIndexVO> index() {
        return Result.success(homeService.index());
    }

}
