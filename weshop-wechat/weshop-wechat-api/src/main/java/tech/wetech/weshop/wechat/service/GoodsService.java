package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.wechat.dto.GoodsCategoryDTO;
import tech.wetech.weshop.wechat.dto.GoodsDetailDTO;
import tech.wetech.weshop.wechat.dto.GoodsListDTO;
import tech.wetech.weshop.wechat.dto.GoodsResultDTO;
import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.query.GoodsSearchQuery;
import tech.wetech.weshop.service.IService;

import java.util.List;

/**
 * @author cjbi@outlook.com
 */
public interface GoodsService extends IService<Goods> {

    GoodsResultDTO queryList(GoodsSearchQuery goodsSearchQuery);

    GoodsDetailDTO queryGoodsDetail(Integer goodsId);

    List<GoodsListDTO> queryRelatedGoods(Integer goodsId);

    GoodsCategoryDTO queryGoodsCategory(Integer categoryId);
}
