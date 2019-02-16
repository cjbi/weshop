package tech.wetech.weshop.marketing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.marketing.api.HomeApi;
import tech.wetech.weshop.marketing.dto.HomeIndexDTO;
import tech.wetech.weshop.marketing.service.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController implements HomeApi {

    @Autowired
    private HomeService homeService;

    @Override
    public HomeIndexDTO index() {
        return homeService.index();
    }
}
