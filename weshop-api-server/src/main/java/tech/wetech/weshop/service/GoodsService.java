package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.query.GoodsSearchQuery;

import java.util.List;

/**
 * @author cjbi
 */
public interface GoodsService extends IService<Goods> {

    List<Goods> queryGoodsByCategoryIdIn(List<Integer> categoryIds);

    PageInfo<Goods> queryGoodsSearchPageInfo(GoodsSearchQuery goodsSearchQuery);

    List<Integer> queryGoodsSearchCategoryIds(GoodsSearchQuery goodsSearchQuery);

}
