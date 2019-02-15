package tech.wetech.weshop.goods.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.goods.po.GoodsIssue;
import tech.wetech.weshop.service.IService;

@RequestMapping("/goodsIssue")
public interface GoodsIssueService extends IService<GoodsIssue> {

}
