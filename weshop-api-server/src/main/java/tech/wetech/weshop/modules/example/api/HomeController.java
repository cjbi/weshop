package tech.wetech.weshop.modules.example.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.modules.example.vo.LoginParamVO;
import tech.wetech.weshop.modules.example.vo.LoginResultVO;
import tech.wetech.weshop.core.utils.BaseController;

import javax.validation.Valid;

/**
 * @author cjbi
 */
@RestController
@Api(description = "主页接口")
public class HomeController extends BaseController {

    @PostMapping("/login")
    @ApiOperation("登录")
    public LoginResultVO login(@RequestBody @Valid LoginParamVO paramVO) {
        logger.info(paramVO.getUserName());
        return new LoginResultVO("super_admin");
    }

}
