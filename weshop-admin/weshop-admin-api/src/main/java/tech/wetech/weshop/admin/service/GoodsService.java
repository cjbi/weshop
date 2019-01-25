package tech.wetech.weshop.admin.service;

import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.query.GoodsSearchQuery;
import tech.wetech.weshop.admin.dto.GoodsCategoryDTO;
import tech.wetech.weshop.admin.dto.GoodsDetailDTO;
import tech.wetech.weshop.admin.dto.GoodsListDTO;
import tech.wetech.weshop.admin.dto.GoodsResultDTO;
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
