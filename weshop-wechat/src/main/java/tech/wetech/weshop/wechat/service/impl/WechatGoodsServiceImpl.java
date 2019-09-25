package tech.wetech.weshop.wechat.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.utils.Criteria;
import tech.wetech.weshop.common.utils.Result;
import tech.wetech.weshop.goods.api.*;
import tech.wetech.weshop.goods.dto.GoodsAttributeDTO;
import tech.wetech.weshop.goods.dto.GoodsSpecificationDTO;
import tech.wetech.weshop.goods.po.*;
import tech.wetech.weshop.goods.query.GoodsSearchQuery;
import tech.wetech.weshop.user.api.CollectApi;
import tech.wetech.weshop.user.api.CommentApi;
import tech.wetech.weshop.user.api.CommentPictureApi;
import tech.wetech.weshop.user.api.UserApi;
import tech.wetech.weshop.user.po.*;
import tech.wetech.weshop.wechat.exception.WeshopWechatException;
import tech.wetech.weshop.wechat.service.WechatGoodsService;
import tech.wetech.weshop.wechat.utils.JwtHelper;
import tech.wetech.weshop.wechat.vo.*;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

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

    @Override
    public GoodsResultVO queryList(GoodsSearchQuery goodsSearchQuery) {
        //没传分类id就查全部
        Criteria<Goods, Object> criteria = Criteria.of(Goods.class);
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
        criteria.fields(Goods::getCategoryId);
        List<Integer> categoryIds = goodsApi.queryByCriteria(criteria).getData().stream()
                .map(Goods::getCategoryId)
                .collect(Collectors.toList());

        if (categoryIds.isEmpty()) {
            return GoodsResultVO.EMPTY_GOODS_RESULT;
        }
        //查询二级分类的parentIds
        List<Integer> parentIds = categoryApi.queryParentIdsByIdIn(categoryIds).getData();
        //一级分类
        List<CategoryFilterVO> categoryFilter = new LinkedList<CategoryFilterVO>() {{
            add(new CategoryFilterVO(0, "全部", false));
            addAll(categoryApi.queryByIdIn(parentIds).getData().stream()
                    .map(CategoryFilterVO::new)
                    .collect(Collectors.toList()));
        }};

        categoryFilter.forEach(categoryFilterDTO -> categoryFilterDTO.setChecked(categoryFilterDTO.getId().equals(goodsSearchQuery.getCategoryId())));

        if (goodsSearchQuery.getCategoryId() != null && goodsSearchQuery.getCategoryId() > 0) {
            //根据一级分类ID查询二级分类ID
            List<Integer> idList = new LinkedList<>();
            idList.add(goodsSearchQuery.getCategoryId());
            idList.addAll(Optional.ofNullable(categoryApi.queryIdsByParentId(goodsSearchQuery.getCategoryId()).getData()).orElse(Collections.EMPTY_LIST));
            criteria.andIn(Goods::getCategoryId, idList);
        }
        if (goodsSearchQuery.getSort() != null) {
            String orderBy = null;
            switch (goodsSearchQuery.getSort()) {
                case "price":
//                    orderBy = "retail_price";
                    if ("desc".equals(goodsSearchQuery.getOrder())) {
                        criteria.sortDesc(Goods::getRetailPrice);
                    } else {
                        criteria.sort(Goods::getRetailPrice);
                    }
                    break;
                default:
                    orderBy = "id";
                    if ("desc".equals(goodsSearchQuery.getOrder())) {
                        criteria.sortDesc(Goods::getId);
                    } else {
                        criteria.sort(Goods::getId);
                    }
            }
        } else {
            //默认按照添加时间排序
            criteria.sortDesc(Goods::getId);
        }
        criteria.fields(
                Goods::getId,
                Goods::getName,
                Goods::getListPicUrl,
                Goods::getRetailPrice);

        List<Goods> goodsList = goodsApi.queryByCriteria(criteria).getData();
        return new GoodsResultVO(goodsList, categoryFilter);
    }

    private List<GoodsDetailVO.GoodsSpecificationVO> queryGoodsDetailSpecificationByGoodsId(Integer goodsId) {
        List<GoodsDetailVO.GoodsSpecificationVO> goodsSpecificationVOList = new LinkedList<>();
        List<GoodsSpecificationDTO> goodsSpecificationBOList = goodsSpecificationApi.queryGoodsDetailSpecificationByGoodsId(goodsId).getData();

        goodsSpecificationBOList.stream()
                .collect(Collectors.toMap(GoodsSpecificationDTO::getSpecificationId, g -> g, (g1, g2) -> g2))
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

        Criteria<Goods, Object> criteria = Criteria.of(Goods.class)
                .fields(Goods::getId, Goods::getName, Goods::getListPicUrl, Goods::getRetailPrice)
                .andIn(Goods::getCategoryId, categoryIdList)
                .page(1, 7);
        return goodsApi.queryByCriteria(criteria).getData();
    }

    @Override
    public GoodsDetailVO queryGoodsDetail(Integer id) {
        User userInfo = JwtHelper.getUserInfo();
        GoodsDetailVO goodsDetailDTO = new GoodsDetailVO();

        Goods goods = ofNullable(goodsApi.queryById(id)).map(Result::getData).orElseThrow(() -> new WeshopWechatException(CommonResultStatus.RECORD_NOT_EXIST));

        List<GoodsGallery> goodsGalleryVOList = goodsGalleryApi.queryList(new GoodsGallery().setGoodsId(id)).getData();
        List<GoodsAttributeDTO> goodsAttributeVOList = goodsAttributeApi.queryGoodsDetailAttributeByGoodsId(id).getData();
        List<GoodsIssue> goodsIssueList = goodsIssueApi.queryAll().getData();
        Brand brand = brandApi.queryById(goods.getBrandId()).getData();

        //商品评价
        int commentCount = commentApi.countByCriteria(Criteria.of(Comment.class).andEqualTo(Comment::getValueId, id).andEqualTo(Comment::getTypeId, 0)).getData();
        if (commentCount > 0) {
            Comment hotComment = commentApi.queryOneByCriteria(Criteria.of(Comment.class).andEqualTo(Comment::getValueId, id).andEqualTo(Comment::getTypeId, 0).page(1, 1)).getData();
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
        List<Collect> userCollect = collectApi.queryByCriteria(Criteria.of(Collect.class).andEqualTo(Collect::getUserId, userInfo.getId()).andEqualTo(Collect::getValueId, id).page(1, 1)).getData();

        goodsDetailDTO.setUserHasCollect(userCollect.size() > 0 ? true : false);

        //记录用户足迹 此处使用异步处理
        Footprint footprint = new Footprint()
                .setUserId(userInfo.getId())
                .setGoodsId(id);
        amqpTemplate.convertAndSend("weshop.topic.footprint", footprint);
        return goodsDetailDTO;
    }

    @Override
    public List<GoodsListVO> queryRelatedGoods(Integer goodsId) {

        List<RelatedGoods> relatedGoodsList = relatedGoodsApi.queryList(new RelatedGoods().setGoodsId(goodsId)).getData();
        List<GoodsListVO> goodsList = null;

        if (relatedGoodsList.isEmpty()) {
            //查找同分类下的商品
            Goods goods = goodsApi.queryById(goodsId).getData();

            goodsList = goodsApi.queryByCriteria(Criteria.of(Goods.class).andEqualTo(Goods::getCategoryId, goods.getCategoryId()).page(1, 8)).getData().stream()
                    .map(GoodsListVO::new)
                    .collect(Collectors.toList());
        } else {
            List<Integer> goodsIdList = relatedGoodsList.stream()
                    .map(RelatedGoods::getGoodsId)
                    .collect(Collectors.toList());

            goodsList = goodsApi.queryByCriteria(Criteria.of(Goods.class).andIn(Goods::getId, goodsIdList).page(1, 8)).getData().stream()
                    .map(GoodsListVO::new)
                    .collect(Collectors.toList());
        }
        return goodsList;
    }

    @Override
    public GoodsCategoryVO queryGoodsCategory(Integer categoryId) {
        Category currentCategory = ofNullable(categoryApi.queryById(categoryId))
            .map(Result::getData)
            .orElseThrow(() -> new WeshopWechatException(CommonResultStatus.RECORD_NOT_EXIST));
        Category parentCategory = categoryApi.queryById(currentCategory.getParentId()).getData();
        List<Category> brotherCategory = categoryApi.queryList(new Category().setParentId(currentCategory.getParentId())).getData();
        return new GoodsCategoryVO(currentCategory, parentCategory, brotherCategory);
    }

}
