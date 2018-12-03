package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.query.GoodsPageQuery;
import tech.wetech.weshop.vo.CreateGoodsFormVO;
import tech.wetech.weshop.vo.UpdateGoodsFormVO;

/**
 * @author cjbi
 */
public interface GoodsService {

    /**
     * 分页查询商品
     *
     * @param goodsPageQuery
     * @return
     */
    PageInfo<Goods> queryGoodsPageInfo(GoodsPageQuery goodsPageQuery);

    /**
     * 创建商品
     *
     * @param createGoodsFormVO
     */
    void createGoods(CreateGoodsFormVO createGoodsFormVO);

    /**
     * 更新商品
     *
     * @param updateGoodsFormVO
     */
    void updateGoods(UpdateGoodsFormVO updateGoodsFormVO);

    /**
     * 删除商品
     * @param goodsId
     */
    void deleteGoods(Integer goodsId);

}
