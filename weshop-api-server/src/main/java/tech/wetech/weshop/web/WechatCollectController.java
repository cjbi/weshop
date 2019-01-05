package tech.wetech.weshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.Collect;
import tech.wetech.weshop.service.CollectService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.AddOrDeleteParamVO;
import tech.wetech.weshop.vo.AddOrDeleteResultVO;

@RestController
@RequestMapping("/wechat/collect")
public class WechatCollectController extends BaseCrudController<Collect> {

    @Autowired
    private CollectService collectService;

    @PostMapping("/add-or-delete")
    public Result<AddOrDeleteResultVO> addOrDelete(@RequestBody AddOrDeleteParamVO addOrDeleteParamVO) {
        return Result.success(collectService.addOrDelete(addOrDeleteParamVO));
    }

}
