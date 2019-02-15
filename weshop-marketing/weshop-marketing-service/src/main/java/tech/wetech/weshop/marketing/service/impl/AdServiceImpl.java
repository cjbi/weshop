package tech.wetech.weshop.marketing.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.marketing.po.Ad;
import tech.wetech.weshop.marketing.service.AdService;
import tech.wetech.weshop.service.BaseService;

/**
 * @author cjbi@outlook.com
 */
@RestController
public class AdServiceImpl extends BaseService<Ad> implements AdService {
}
