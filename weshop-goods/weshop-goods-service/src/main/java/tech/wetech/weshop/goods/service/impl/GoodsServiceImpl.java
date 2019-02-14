package tech.wetech.weshop.goods.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.enums.ResultCodeEnum;
import tech.wetech.weshop.exception.BizException;
import tech.wetech.weshop.goods.bo.GoodsAttributeBO;
import tech.wetech.weshop.goods.bo.GoodsSpecificationBO;
import tech.wetech.weshop.goods.dto.*;
import tech.wetech.weshop.goods.mapper.*;
import tech.wetech.weshop.goods.po.*;
import tech.wetech.weshop.goods.query.GoodsSearchQuery;
import tech.wetech.weshop.goods.service.GoodsService;
import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.po.CommentPicture;
import tech.wetech.weshop.marketing.service.CommentPictureService;
import tech.wetech.weshop.marketing.service.CommentService;
import tech.wetech.weshop.service.BaseService;
import tech.wetech.weshop.user.po.Collect;
import tech.wetech.weshop.user.po.Footprint;
import tech.wetech.weshop.user.po.User;
import tech.wetech.weshop.user.service.CollectService;
import tech.wetech.weshop.user.service.FootprintService;
import tech.wetech.weshop.user.service.UserService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Reflections;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl extends BaseService<Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private GoodsGalleryMapper goodsGalleryMapper;

    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;

    @Autowired
    private GoodsIssueMapper goodsIssueMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentPictureService commentPictureService;

    @Autowired
    private UserService userService;

    @Autowired
    private FootprintService footprintService;

    @Autowired
    private CollectService collectService;

    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RelatedGoodsMapper relatedGoodsMapper;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public GoodsResultDTO queryList(GoodsSearchQuery goodsSearchQuery) {
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
        List<Integer> categoryIds = goodsMapper.selectByExample(example).stream()
                .map(Goods::getCategoryId)
                .collect(Collectors.toList());

        if (categoryIds.isEmpty()) {
            return GoodsResultDTO.EMPTY_GOODS_RESULT;
        }
        //查询二级分类的parentIds
        List<Integer> parentIds = categoryMapper.selectParentIdsByIdIn(categoryIds);
        //一级分类
        List<CategoryFilterDTO> categoryFilter = new LinkedList<CategoryFilterDTO>() {{
            add(new CategoryFilterDTO(0, "全部", false));
            addAll(categoryMapper.selectByIdIn(parentIds).stream()
                    .map(CategoryFilterDTO::new)
                    .collect(Collectors.toList()));
        }};

        categoryFilter.forEach(categoryFilterDTO -> categoryFilterDTO.setChecked(categoryFilterDTO.getId().equals(goodsSearchQuery.getCategoryId())));

        if (goodsSearchQuery.getCategoryId() != null && goodsSearchQuery.getCategoryId() > 0) {
            //根据一级分类ID查询二级分类ID
            List<Integer> idList = new LinkedList<>();
            idList.add(goodsSearchQuery.getCategoryId());
            idList.addAll(Optional.ofNullable(categoryMapper.selectIdsByParentId(goodsSearchQuery.getCategoryId())).orElse(Collections.EMPTY_LIST));
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
        List<Goods> goodsList = PageHelper.startPage(goodsSearchQuery)
                .doSelectPage(() -> goodsMapper.selectByExample(example));

        return new GoodsResultDTO(goodsList, categoryFilter);
    }

    private List<GoodsDetailDTO.GoodsSpecificationVO> queryGoodsDetailSpecificationByGoodsId(Integer goodsId) {
        List<GoodsDetailDTO.GoodsSpecificationVO> goodsSpecificationVOList = new LinkedList<>();
        List<GoodsSpecificationBO> goodsSpecificationBOList = goodsSpecificationMapper.selectGoodsDetailSpecificationByGoodsId(goodsId);

        goodsSpecificationBOList.stream()
                .collect(Collectors.toMap(GoodsSpecificationBO::getSpecificationId, g -> g, (g1, g2) -> g2))
                .forEach((k, v) -> {
                    GoodsDetailDTO.GoodsSpecificationVO goodsSpecificationVO = new GoodsDetailDTO.GoodsSpecificationVO();
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
        return goodsMapper.selectByExample(goodsWeekend);
    }

    @Override
    public GoodsDetailDTO queryGoodsDetail(Integer id) {
        GoodsDetailDTO goodsDetailDTO = new GoodsDetailDTO();

        Goods goods = goodsMapper.selectByPrimaryKey(id);
        List<GoodsGallery> goodsGalleryVOList = goodsGalleryMapper.select(new GoodsGallery().setGoodsId(id));
        List<GoodsAttributeBO> goodsAttributeVOList = goodsAttributeMapper.selectGoodsDetailAttributeByGoodsId(id);
        List<GoodsIssue> goodsIssueList = goodsIssueMapper.selectAll();
        Brand brand = brandMapper.selectByPrimaryKey(goods.getBrandId());

        //商品评价
        int commentCount = commentService.count(new Comment().setValueId(id).setTypeId((byte) 0));
        PageHelper.startPage(1, 1);
        Comment hotComment = commentService.queryOne(new Comment().setValueId(id).setTypeId((byte) 0));
        if (hotComment != null) {
            GoodsDetailDTO.CommentVO.CommentDataVO commentData = new GoodsDetailDTO.CommentVO.CommentDataVO();
            String content = new String(Base64.getDecoder().decode(hotComment.getContent()));
            User user = userService.queryById(hotComment.getUserId());
            List<String> picList = commentPictureService.queryList(new CommentPicture().setCommentId(hotComment.getId())).stream()
                    .map(CommentPicture::getPicUrl)
                    .collect(Collectors.toList());

            commentData.setContent(content);
            commentData.setNickname(user.getNickname());
            commentData.setAvatar(user.getAvatar());
            commentData.setPicList(picList);
            commentData.setCreateTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(hotComment.getCreateTime()));
            goodsDetailDTO.setComment(new GoodsDetailDTO.CommentVO(commentCount, commentData));
        }


        List<GoodsDetailDTO.GoodsSpecificationVO> goodsSpecificationVOList = this.queryGoodsDetailSpecificationByGoodsId(id);
        List<Product> productList = productMapper.select(new Product().setGoodsId(id));

        goodsDetailDTO.setGoods(goods);

        goodsDetailDTO.setBrand(brand);
        goodsDetailDTO.setGoodsGalleryList(goodsGalleryVOList);
        goodsDetailDTO.setGoodsAttributeList(goodsAttributeVOList);
        goodsDetailDTO.setGoodsIssueList(goodsIssueList);
        goodsDetailDTO.setGoodsSpecificationList(goodsSpecificationVOList);
        goodsDetailDTO.setProductList(productList);

        //用户是否收藏
        PageHelper.startPage(1, 1);
        Collect userCollect = collectService.queryOne(new Collect().setUserId(Constants.CURRENT_USER_ID).setValueId(id));
        goodsDetailDTO.setUserHasCollect(userCollect == null ? false : true);

        //记录用户足迹 此处使用异步处理
        Footprint footprint = new Footprint()
                .setUserId(Constants.CURRENT_USER_ID)
                .setGoodsId(id);
        applicationEventPublisher.publishEvent(footprint);
        return goodsDetailDTO;
    }

    @Override
    public List<GoodsListDTO> queryRelatedGoods(Integer goodsId) {

        List<RelatedGoods> relatedGoodsList = relatedGoodsMapper.select(new RelatedGoods().setGoodsId(goodsId));
        List<GoodsListDTO> goodsList = null;

        if (relatedGoodsList.isEmpty()) {
            //查找同分类下的商品
            Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
            PageHelper.startPage(1, 8);
            goodsList = goodsMapper.select(new Goods().setCategoryId(goods.getCategoryId())).stream()
                    .map(GoodsListDTO::new)
                    .collect(Collectors.toList());
        } else {
            List<Integer> goodsIdList = relatedGoodsList.stream()
                    .map(RelatedGoods::getGoodsId)
                    .collect(Collectors.toList());
            PageHelper.startPage(1, 8);
            goodsList = goodsMapper.selectByIdIn(goodsIdList).stream()
                    .map(GoodsListDTO::new)
                    .collect(Collectors.toList());
        }
        return goodsList;
    }

    @Override
    public GoodsCategoryDTO queryGoodsCategory(Integer categoryId) {
        Category currentCategory = Optional.ofNullable(categoryMapper.selectByPrimaryKey(categoryId))
                .orElseThrow(() -> new BizException(ResultCodeEnum.RECORD_NOT_EXIST));
        Category parentCategory = categoryMapper.selectByPrimaryKey(currentCategory.getParentId());
        List<Category> brotherCategory = categoryMapper.select(new Category().setParentId(currentCategory.getParentId()));
        return new GoodsCategoryDTO(currentCategory, parentCategory, brotherCategory);
    }
}
