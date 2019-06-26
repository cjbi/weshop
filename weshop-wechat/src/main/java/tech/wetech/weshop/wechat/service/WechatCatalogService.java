package tech.wetech.weshop.wechat.service;

import tech.wetech.weshop.goods.enums.CategoryLevelEnum;
import tech.wetech.weshop.goods.po.Category;
import tech.wetech.weshop.wechat.vo.CategoryIndexVO;
import tech.wetech.weshop.wechat.vo.CategoryVO;

import java.util.List;

public interface WechatCatalogService {

    /**
     * 根据类目查询商品
     *
     * @param categoryLevel
     * @return
     */
    List<Category> queryCategoryByLevel(CategoryLevelEnum categoryLevel);

    CategoryIndexVO index(Integer cateogyId);

    CategoryVO current(Integer id);

}
