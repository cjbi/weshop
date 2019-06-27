package tech.wetech.weshop.goods.fallback;

import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.fallback.ApiFallback;
import tech.wetech.weshop.goods.api.GoodsAttributeApi;
import tech.wetech.weshop.goods.dto.GoodsAttributeDTO;
import tech.wetech.weshop.goods.po.GoodsAttribute;

import java.util.Collections;
import java.util.List;

@Component
public class GoodsAttributeApiFallback extends ApiFallback<GoodsAttribute> implements GoodsAttributeApi {

    @Override
    public List<GoodsAttributeDTO> queryGoodsDetailAttributeByGoodsId(Integer goodsId) {
        return Collections.emptyList();
    }
}
