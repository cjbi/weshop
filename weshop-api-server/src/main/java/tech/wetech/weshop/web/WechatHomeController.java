package tech.wetech.weshop.web;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.po.*;
import tech.wetech.weshop.service.*;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.HomeCategoryVO;
import tech.wetech.weshop.vo.HomeIndexVO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/wechat/home")
public class WechatHomeController {

    @Autowired
    private AdService adService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private TopicService topicService;


    @GetMapping("/index")
    public Result<HomeIndexVO> index() {
        HomeIndexVO homeIndexVO = new HomeIndexVO();

        List<Ad> bannerList = adService.queryList(new Ad() {{
            setAdPositionId((short) 1);
        }});

        PageHelper.orderBy("sort_order asc");
        List<Channel> channelList = channelService.queryAll();

        PageHelper.startPage(1, 4);
        List<Goods> newGoodsList = goodsService.queryList(new Goods().setNew(true));

        PageHelper.startPage(1, 4);
        List<Goods> hotGoodsList = goodsService.queryList(new Goods().setHot(true));

        PageHelper.orderBy("new_sort_order asc");
        List<Brand> brandList = brandService.queryList(new Brand().setNew(true));

        PageHelper.startPage(1, 3);
        List<Topic> topicList = topicService.queryAll();

        List<HomeCategoryVO> categoryList = new LinkedList<>();

        categoryService.queryList(
                new Category().setParentId(0)
        ).forEach(c -> {

            List<Integer> categoryIdList = categoryService.queryList(new Category().setParentId(c.getId())).stream()
                    .map(Category::getId)
                    .collect(Collectors.toList());

            PageHelper.startPage(1, 7);
            List<Goods> goodsList = goodsService.queryGoodsByCategoryIdIn(categoryIdList);
            categoryList.add(new HomeCategoryVO(c.getId(), c.getName(), goodsList));
        });
        homeIndexVO.setBannerList(bannerList)
                .setChannelList(channelList)
                .setNewGoodsList(newGoodsList)
                .setHotGoodsList(hotGoodsList)
                .setBrandList(brandList)
                .setTopicList(topicList)
                .setCategoryList(categoryList);

        return Result.success(homeIndexVO);
    }

}
