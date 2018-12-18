package tech.wetech.weshop.web;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.domain.*;
import tech.wetech.weshop.service.*;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CategoryVO;
import tech.wetech.weshop.vo.IndexVO;

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
    public Result<IndexVO> index() {
        IndexVO indexVO = new IndexVO();

        List<Ad> bannerList = adService.queryList(new Ad() {{
            setAdPositionId((short) 1);
        }});

        PageHelper.orderBy("sort_order asc");
        List<Channel> channelList = channelService.queryAll();

        PageHelper.startPage(1, 4);
        List<Goods> newGoodsList = goodsService.queryList(new Goods() {{
            setIsNew(true);
        }});

        PageHelper.startPage(1, 4);
        List<Goods> hotGoodsList = goodsService.queryList(new Goods() {{
            setIsHot(true);
        }});

        PageHelper.orderBy("new_sort_order asc");
        List<Brand> brandList = brandService.queryList(new Brand() {{
            setIsNew(true);
        }});

        PageHelper.startPage(1, 3);
        List<Topic> topicList = topicService.queryAll();

        List<CategoryVO> categoryList = new LinkedList<>();
        categoryService.queryList(new Category() {{
            setParentId(0);
        }}).forEach(c -> {

            List<Integer> categoryIdList = categoryService.queryList(new Category() {{
                setParentId(c.getId());
            }}).stream()
                    .map(Category::getId)
                    .collect(Collectors.toList());

            PageHelper.startPage(1, 7);
            List<Goods> goodsList = goodsService.queryGoodsByCategoryIdIn(categoryIdList);
            categoryList.add(new CategoryVO(c.getId(), c.getName(), goodsList));
        });


        indexVO.setBannerList(bannerList);
        indexVO.setChannelList(channelList);
        indexVO.setNewGoodsList(newGoodsList);
        indexVO.setHotGoodsList(hotGoodsList);
        indexVO.setBrandList(brandList);
        indexVO.setTopicList(topicList);
        indexVO.setCategoryList(categoryList);

        return Result.success(indexVO);
    }

}
