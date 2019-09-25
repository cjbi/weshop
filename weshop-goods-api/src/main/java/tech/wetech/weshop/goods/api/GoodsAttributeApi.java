package tech.wetech.weshop.goods.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.goods.dto.GoodsAttributeDTO;
import tech.wetech.weshop.goods.fallback.GoodsAttributeApiFallback;
import tech.wetech.weshop.goods.po.GoodsAttribute;

import java.util.List;

@FeignClient(value = "weshop-goods", path = "goodsAttribute", fallback = GoodsAttributeApiFallback.class)
public interface GoodsAttributeApi extends Api<GoodsAttribute> {

    @GetMapping("/queryGoodsDetailAttributeByGoodsId")
    Result<List<GoodsAttributeDTO>> queryGoodsDetailAttributeByGoodsId(@RequestParam("goodsId") Integer goodsId);

}
