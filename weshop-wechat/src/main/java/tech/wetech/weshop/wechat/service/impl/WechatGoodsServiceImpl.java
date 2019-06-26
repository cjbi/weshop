package tech.wetech.weshop.wechat.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.enums.ResultCodeEnum;
import tech.wetech.weshop.common.exception.BizException;
import tech.wetech.weshop.common.query.QueryWrapper;
import tech.wetech.weshop.common.utils.Constants;
import tech.wetech.weshop.common.utils.Reflections;
import tech.wetech.weshop.goods.api.*;
import tech.wetech.weshop.goods.bo.GoodsAttributeBO;
import tech.wetech.weshop.goods.bo.GoodsSpecificationBO;
import tech.wetech.weshop.goods.po.*;
import tech.wetech.weshop.goods.query.GoodsSearchQuery;
import tech.wetech.weshop.marketing.api.CommentApi;
import tech.wetech.weshop.marketing.api.CommentPictureApi;
import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.po.CommentPicture;
import tech.wetech.weshop.user.api.CollectApi;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.po.Collect;
import tech.wetech.weshop.user.po.Footprint;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.wechat.service.WechatGoodsService;
import tech.wetech.weshop.wechat.vo.*;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WechatGoodsServiceImpl implements WechatGoodsService {

    @Autowired
    private GoodsApi goodsApi;

    @Autowired
    private CategoryApi categoryApi;

    @Autowired
    private GoodsGalleryApi goodsGalleryApi;

    @Autowired
    private GoodsAttributeApi goodsAttributeApi;

    @Autowired
    private GoodsIssueApi goodsIssueApi;

    @Autowired
    private BrandApi brandApi;

    @Autowired
    private CommentApi commentApi;

    @Autowired
    private CommentPictureApi commentPictureApi;

    @Autowired
    private UserApi userApi;

    @Autowired
    private CollectApi collectApi;

    @Autowired
    private GoodsSpecificationApi goodsSpecificationApi;

    @Autowired
    private ProductApi productApi;

    @Autowired
    private RelatedGoodsApi relatedGoodsApi;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${message.queue.footprint}")
    private String footprintQueue;

    @Override
    public GoodsResultVO queryList(GoodsSearchQuery goodsSearchQuery) {
        Weekend<Goods> example = Weekend.of(Goods.class);
        WeekendCriteria<Goods, Object> criteria = example.weekendCriteria();
        //没传分类id就查全部
        if (goodsSearchQuery.getCategoryId() == null) {
            goodsSearchQuery.setCategoryId(0);
        }
        if (goodsSearchQuery.getBrandId() != null) {
            criteria.andEqualTo(Goods::getBrandId, goodsSearchQuery.getBrandId());
        }
        if (goodsSearchQuery.getKeyword() != null) {
            criteria.andLike(Goods::getName, "%" + goodsSearchQuery.getKeyword() + "%");
        }
        if (goodsSearchQuery.getNewly() != null) {
            criteria.andEqualTo(Goods::getNewly, goodsSearchQuery.getNewly());
        }
        if (goodsSearchQuery.getHot() != null) {
            criteria.andEqualTo(Goods::getHot, goodsSearchQuery.getHot());
        }
        example.selectProperties(Reflections.fnToFieldName(
                Goods::getCategoryId));
        List<Integer> categoryIds = goodsApi.queryListByQueryWrapper(new QueryWrapper().setCondition(example)).getData().stream()
                .map(Goods::getCategoryId)
                .collect(Collectors.toList());

        if (categoryIds.isEmpty()) {
            return GoodsResultVO.EMPTY_GOODS_RESULT;
        }
        //查询二级分类的parentIds
        List<Integer> parentIds = categoryApi.queryParentIdsByIdIn(categoryIds);
        //一级分类
        List<CategoryFilterVO> categoryFilter = new LinkedList<CategoryFilterVO>() {{
            add(new CategoryFilterVO(0, "全部", false));
            addAll(categoryApi.queryByIdIn(parentIds).stream()
                    .map(CategoryFilterVO::new)
                    .collect(Collectors.toList()));
        }};

        categoryFilter.forEach(categoryFilterDTO -> categoryFilterDTO.setChecked(categoryFilterDTO.getId().equals(goodsSearchQuery.getCategoryId())));

        if (goodsSearchQuery.getCategoryId() != null && goodsSearchQuery.getCategoryId() > 0) {
            //根据一级分类ID查询二级分类ID
            List<Integer> idList = new LinkedList<>();
            idList.add(goodsSearchQuery.getCategoryId());
            idList.addAll(Optional.ofNullable(categoryApi.queryIdsByParentId(goodsSearchQuery.getCategoryId())).orElse(Collections.EMPTY_LIST));
            criteria.andIn(Goods::getCategoryId, idList);
        }
        if (goodsSearchQuery.getSort() != null) {
            String orderBy = null;
            switch (goodsSearchQuery.getSort()) {
                case "price":
                    orderBy = "retail_price";
                default:
                    orderBy = "id";
            }
            if (goodsSearchQuery.getOrder() != null) {
                orderBy += " " + goodsSearchQuery.getOrder();
            }
            example.setOrderByClause(orderBy);
        } else {
            //默认按照添加时间排序
            example.setOrderByClause("id desc");
        }
        example.selectProperties(Reflections.fnToFieldName(
                Goods::getId,
                Goods::getName,
                Goods::getListPicUrl,
                Goods::getRetailPrice));
        List<Goods> goodsList = goodsApi.queryListByQueryWrapper(new QueryWrapper(goodsSearchQuery, example)).getData();
        return new GoodsResultVO(goodsList, categoryFilter);
    }

    private List<GoodsDetailVO.GoodsSpecificationVO> queryGoodsDetailSpecificationByGoodsId(Integer goodsId) {
        List<GoodsDetailVO.GoodsSpecificationVO> goodsSpecificationVOList = new LinkedList<>();
        List<GoodsSpecificationBO> goodsSpecificationBOList = goodsSpecificationApi.queryGoodsDetailSpecificationByGoodsId(goodsId);

        goodsSpecificationBOList.stream()
                .collect(Collectors.toMap(GoodsSpecificationBO::getSpecificationId, g -> g, (g1, g2) -> g2))
                .forEach((k, v) -> {
                    GoodsDetailVO.GoodsSpecificationVO goodsSpecificationVO = new GoodsDetailVO.GoodsSpecificationVO();
                    goodsSpecificationVO.setSpecificationId(k);
                    goodsSpecificationVO.setName(v.getName());
                    goodsSpecificationVO.setValueList(
                            goodsSpecificationBOList.stream()
                                    .filter(g -> g.getSpecificationId().equals(v.getSpecificationId()))
                                    .collect(Collectors.toList())
                    );
                    goodsSpecificationVOList.add(goodsSpecificationVO);
                });

        return goodsSpecificationVOList;
    }

    @Override
    public List<Goods> queryListByCategoryIdIn(List<Integer> categoryIdList) {
        PageHelper.startPage(1, 7);
        Weekend<Goods> goodsWeekend = Weekend.of(Goods.class);
        goodsWeekend.selectProperties(Reflections.fnToFieldName(
                Goods::getId,
                Goods::getName,
                Goods::getListPicUrl,
                Goods::getRetailPrice));
        WeekendCriteria<Goods, Object> criteria = goodsWeekend.weekendCriteria();
        criteria.andIn(Goods::getCategoryId, categoryIdList);
        return goodsApi.queryListByQueryWrapper(new QueryWrapper().setCondition(goodsWeekend)).getData();
    }

    @Override
    public GoodsDetailVO queryGoodsDetail(Integer id) {
        GoodsDetailVO goodsDetailDTO = new GoodsDetailVO();

        Goods goods = goodsApi.queryById(id).getData();
        List<GoodsGallery> goodsGalleryVOList = goodsGalleryApi.queryList(new GoodsGallery().setGoodsId(id)).getData();
        List<GoodsAttributeBO> goodsAttributeVOList = goodsAttributeApi.queryGoodsDetailAttributeByGoodsId(id);
        List<GoodsIssue> goodsIssueList = goodsIssueApi.queryAll().getData();
        Brand brand = brandApi.queryById(goods.getBrandId()).getData();

        //商品评价
        int commentCount = commentApi.count(new Comment().setValueId(id).setTypeId((byte) 0)).getData();
        PageHelper.startPage(1, 1);
        Comment hotComment = commentApi.queryOne(new Comment().setValueId(id).setTypeId((byte) 0)).getData();
        if (hotComment != null) {
            GoodsDetailVO.CommentVO.CommentDataVO commentData = new GoodsDetailVO.CommentVO.CommentDataVO();
            String content = new String(Base64.getDecoder().decode(hotComment.getContent()));
            User user = userApi.queryById(hotComment.getUserId()).getData();
            List<String> picList = commentPictureApi.queryList(new CommentPicture().setCommentId(hotComment.getId())).getData().stream()
                    .map(CommentPicture::getPicUrl)
                    .collect(Collectors.toList());

            commentData.setContent(content);
            commentData.setNickname(user.getNickname());
            commentData.setAvatar(user.getAvatar());
            commentData.setPicList(picList);
            commentData.setCreateTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(hotComment.getCreateTime()));
            goodsDetailDTO.setComment(new GoodsDetailVO.CommentVO(commentCount, commentData));
        }


        List<GoodsDetailVO.GoodsSpecificationVO> goodsSpecificationVOList = this.queryGoodsDetailSpecificationByGoodsId(id);
        List<Product> productList = productApi.queryList(new Product().setGoodsId(id)).getData();

        goodsDetailDTO.setGoods(goods);

        goodsDetailDTO.setBrand(brand);
        goodsDetailDTO.setGoodsGalleryList(goodsGalleryVOList);
        goodsDetailDTO.setGoodsAttributeList(goodsAttributeVOList);
        goodsDetailDTO.setGoodsIssueList(goodsIssueList);
        goodsDetailDTO.setGoodsSpecificationList(goodsSpecificationVOList);
        goodsDetailDTO.setProductList(productList);

        //用户是否收藏
        PageHelper.startPage(1, 1);
        Collect userCollect = collectApi.queryOne(new Collect().setUserId(Constants.CURRENT_USER_ID).setValueId(id)).getData();
        goodsDetailDTO.setUserHasCollect(userCollect == null ? false : true);

        //记录用户足迹 此处使用异步处理
        Footprint footprint = new Footprint()
                .setUserId(Constants.CURRENT_USER_ID)
                .setGoodsId(id);
        amqpTemplate.convertAndSend(footprintQueue, footprint);
        return goodsDetailDTO;
    }

    @Override
    public List<GoodsListVO> queryRelatedGoods(Integer goodsId) {

        List<RelatedGoods> relatedGoodsList = relatedGoodsApi.queryList(new RelatedGoods().setGoodsId(goodsId)).getData();
        List<GoodsListVO> goodsList = null;

        if (relatedGoodsList.isEmpty()) {
            //查找同分类下的商品
            Goods goods = goodsApi.queryById(goodsId).getData();
            PageHelper.startPage(1, 8);
            goodsList = goodsApi.queryList(new Goods().setCategoryId(goods.getCategoryId())).getData().stream()
                    .map(GoodsListVO::new)
                    .collect(Collectors.toList());
        } else {
            List<Integer> goodsIdList = relatedGoodsList.stream()
                    .map(RelatedGoods::getGoodsId)
                    .collect(Collectors.toList());
            PageHelper.startPage(1, 8);

            Weekend<Goods> example = Weekend.of(Goods.class);
            WeekendCriteria<Goods, Object> criteria = example.weekendCriteria();
            criteria.andIn(Goods::getId, goodsIdList);

            goodsList = goodsApi.queryListByQueryWrapper(new QueryWrapper().setCondition(example)).getData().stream()
                    .map(GoodsListVO::new)
                    .collect(Collectors.toList());
        }
        return goodsList;
    }

    @Override
    public GoodsCategoryVO queryGoodsCategory(Integer categoryId) {
        Category currentCategory = Optional.ofNullable(categoryApi.queryById(categoryId).getData())
                .orElseThrow(() -> new BizException(ResultCodeEnum.RECORD_NOT_EXIST));
        Category parentCategory = categoryApi.queryById(currentCategory.getParentId()).getData();
        List<Category> brotherCategory = categoryApi.queryList(new Category().setParentId(currentCategory.getParentId())).getData();
        return new GoodsCategoryVO(currentCategory, parentCategory, brotherCategory);
    }

}
