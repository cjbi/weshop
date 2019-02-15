package tech.wetech.weshop.marketing.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.goods.po.Brand;
import tech.wetech.weshop.goods.po.Category;
import tech.wetech.weshop.goods.po.Channel;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.goods.service.BrandService;
import tech.wetech.weshop.goods.service.CategoryService;
import tech.wetech.weshop.goods.service.ChannelService;
import tech.wetech.weshop.goods.service.GoodsService;
import tech.wetech.weshop.marketing.dto.HomeCategoryDTO;
import tech.wetech.weshop.marketing.dto.HomeIndexDTO;
import tech.wetech.weshop.marketing.mapper.AdMapper;
import tech.wetech.weshop.marketing.mapper.TopicMapper;
import tech.wetech.weshop.marketing.po.Ad;
import tech.wetech.weshop.marketing.po.Topic;
import tech.wetech.weshop.marketing.service.HomeService;
import tech.wetech.weshop.query.PageQuery;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HomeServiceImpl implements HomeService {

    @Autowired
    private AdMapper adMapper;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private CategoryService categoryService;

    @Override
    public HomeIndexDTO index() {

        List<Ad> bannerList = adMapper.select(new Ad().setAdPositionId((short) 1));

        PageHelper.orderBy("sort_order asc");
        List<Channel> channelList = channelService.queryAll();

        List<Goods> newGoodsList = goodsService.queryPageList(new Goods().setNewly(true), new PageQuery(1, 4));

        PageHelper.startPage(1, 4);
        List<Goods> hotGoodsList = goodsService.queryPageList(new Goods().setHot(true), new PageQuery(1, 4));

        PageHelper.orderBy("new_sort_order asc");
        List<Brand> brandList = brandService.queryList(new Brand().setNewly(true));

        PageHelper.startPage(1, 3);
        List<Topic> topicList = topicMapper.selectAll();

        List<HomeCategoryDTO> categoryList = new LinkedList<>();

        categoryService.queryList(
                new Category().setParentId(0)
        ).forEach(c -> {

            List<Integer> categoryIdList = categoryService.queryList(new Category().setParentId(c.getId())).stream()
                    .map(Category::getId)
                    .collect(Collectors.toList());

            List<Goods> goodsList = goodsService.queryListByCategoryIdIn(categoryIdList);
            categoryList.add(new HomeCategoryDTO(c.getId(), c.getName(), goodsList));
        });

        return new HomeIndexDTO().setBannerList(bannerList)
                .setChannelList(channelList)
                .setNewGoodsList(newGoodsList)
                .setHotGoodsList(hotGoodsList)
                .setBrandList(brandList)
                .setTopicList(topicList)
                .setCategoryList(categoryList);
    }

}
