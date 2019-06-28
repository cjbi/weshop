package tech.wetech.weshop.wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.query.Criteria;
import tech.wetech.weshop.goods.api.BrandApi;
import tech.wetech.weshop.goods.api.CategoryApi;
import tech.wetech.weshop.goods.api.ChannelApi;
import tech.wetech.weshop.goods.api.GoodsApi;
import tech.wetech.weshop.goods.po.Brand;
import tech.wetech.weshop.goods.po.Category;
import tech.wetech.weshop.goods.po.Channel;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.marketing.api.AdApi;
import tech.wetech.weshop.marketing.api.TopicApi;
import tech.wetech.weshop.marketing.po.Ad;
import tech.wetech.weshop.marketing.po.Topic;
import tech.wetech.weshop.wechat.service.WechatHomeService;
import tech.wetech.weshop.wechat.vo.HomeCategoryVO;
import tech.wetech.weshop.wechat.vo.HomeIndexVO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WechatHomeServiceImpl implements WechatHomeService {
    @Autowired
    private AdApi adApi;

    @Autowired
    private ChannelApi channelApi;

    @Autowired
    private GoodsApi goodsApi;

    @Autowired
    private BrandApi brandApi;

    @Autowired
    private TopicApi topicApi;

    @Autowired
    private CategoryApi categoryApi;

    @Override
    @Cacheable("index")
    public HomeIndexVO index() {

        List<Ad> bannerList = adApi.queryList(new Ad().setAdPositionId((short) 1)).getData();

        channelApi.queryByCriteria(Criteria.of(Channel.class).sort(Channel::getSortOrder));

        List<Channel> channelList = channelApi.queryByCriteria(Criteria.of(Channel.class).sort(Channel::getSortOrder)).getData();

        Criteria.of(Goods.class).page(1,4).andEqualTo(Goods::getNewly,true);

        List<Goods> newGoodsList = goodsApi.queryByCriteria(Criteria.of(Goods.class).page(1,4).andEqualTo(Goods::getNewly,true)).getData();

        List<Goods> hotGoodsList = goodsApi.queryByCriteria(Criteria.of(Goods.class).page(1,4).andEqualTo(Goods::getHot,true)).getData();

        List<Brand> brandList = brandApi.queryByCriteria(Criteria.of(Brand.class).andEqualTo(Brand::getNewly,true).sort(Brand::getNewSortOrder)).getData();

        List<Topic> topicList = topicApi.queryAll().getData();

        List<HomeCategoryVO> categoryList = new LinkedList<>();

        categoryApi.queryList(
                new Category().setParentId(0)
        ).getData().forEach(c -> {

            List<Integer> categoryIdList = categoryApi.queryList(new Category().setParentId(c.getId())).getData().stream()
                    .map(Category::getId)
                    .collect(Collectors.toList());

            List<Goods> goodsList = goodsApi.queryByCriteria(Criteria.of(Goods.class).andIn(Goods::getCategoryId, categoryIdList)).getData();
            categoryList.add(new HomeCategoryVO(c.getId(), c.getName(), goodsList));
        });

        return new HomeIndexVO().setBannerList(bannerList)
                .setChannelList(channelList)
                .setNewGoodsList(newGoodsList)
                .setHotGoodsList(hotGoodsList)
                .setBrandList(brandList)
                .setTopicList(topicList)
                .setCategoryList(categoryList);
    }
}
