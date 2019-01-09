package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.bo.GoodsAttributeBO;
import tech.wetech.weshop.bo.GoodsSpecificationBO;
import tech.wetech.weshop.mapper.*;
import tech.wetech.weshop.po.*;
import tech.wetech.weshop.query.GoodsSearchQuery;
import tech.wetech.weshop.service.GoodsService;
import tech.wetech.weshop.utils.Reflections;
import tech.wetech.weshop.vo.*;
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
    private CommentMapper commentMapper;

    @Autowired
    private CommentPictureMapper commentPictureMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RelatedGoodsMapper relatedGoodsMapper;

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
        List<Integer> categoryIds = goodsMapper.selectByExample(example).stream()
                .map(Goods::getCategoryId)
                .collect(Collectors.toList());

        //查询二级分类的parentIds
        List<Integer> parentIds = categoryMapper.selectParentIdsByIdIn(categoryIds);
        //一级分类
        List<CategoryFilterVO> categoryFilter = new LinkedList<CategoryFilterVO>() {{
            add(new CategoryFilterVO(0, "全部", false));
            addAll(categoryMapper.selectByIdIn(parentIds).stream()
                    .map(CategoryFilterVO::new)
                    .collect(Collectors.toList()));
        }};

        categoryFilter.forEach(categoryFilterVO -> categoryFilterVO.setChecked(categoryFilterVO.getId().equals(goodsSearchQuery.getCategoryId())));

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

        return new GoodsResultVO(goodsList, categoryFilter);
    }

    private List<GoodsDetailVO.GoodsSpecificationVO> queryGoodsDetailSpecificationByGoodsId(Integer goodsId) {
        List<GoodsDetailVO.GoodsSpecificationVO> goodsSpecificationVOList = new LinkedList<>();
        List<GoodsSpecificationBO> goodsSpecificationBOList = goodsSpecificationMapper.selectGoodsDetailSpecificationByGoodsId(goodsId);

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
    public GoodsDetailVO queryGoodsDetail(Integer id) {
        GoodsDetailVO goodsDetailVO = new GoodsDetailVO();

        Goods goods = goodsMapper.selectByPrimaryKey(id);
        List<GoodsGallery> goodsGalleryVOList = goodsGalleryMapper.select(new GoodsGallery().setGoodsId(id));
        List<GoodsAttributeBO> goodsAttributeVOList = goodsAttributeMapper.selectGoodsDetailAttributeByGoodsId(id);
        List<GoodsIssue> goodsIssueList = goodsIssueMapper.selectAll();
        Brand brand = brandMapper.selectByPrimaryKey(goods.getBrandId());

        //商品评价
        int commentCount = commentMapper.selectCount(new Comment().setValueId(id).setTypeId((byte) 0));
        PageHelper.startPage(1, 1);
        Comment hotComment = commentMapper.selectOne(new Comment().setValueId(id).setTypeId((byte) 0));
        if (hotComment != null) {
            GoodsDetailVO.CommentVO.CommentDataVO commentData = new GoodsDetailVO.CommentVO.CommentDataVO();
            String content = new String(Base64.getDecoder().decode(hotComment.getContent()));
            User user = userMapper.selectByPrimaryKey(hotComment.getUserId());
            List<String> picList = commentPictureMapper.select(new CommentPicture().setCommentId(hotComment.getId())).stream()
                    .map(CommentPicture::getPicUrl)
                    .collect(Collectors.toList());

            commentData.setContent(content);
            commentData.setNickname(user.getNickname());
            commentData.setAvatar(user.getAvatar());
            commentData.setPicList(picList);
            commentData.setCreateTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(hotComment.getCreateTime()));
            goodsDetailVO.setComment(new GoodsDetailVO.CommentVO(commentCount, commentData));
        }


        List<GoodsDetailVO.GoodsSpecificationVO> goodsSpecificationVOList = this.queryGoodsDetailSpecificationByGoodsId(id);
        List<Product> productList = productMapper.select(new Product().setGoodsId(id));

        goodsDetailVO.setGoods(goods);

        goodsDetailVO.setBrand(brand);
        goodsDetailVO.setGoodsGalleryList(goodsGalleryVOList);
        goodsDetailVO.setGoodsAttributeList(goodsAttributeVOList);
        goodsDetailVO.setGoodsIssueList(goodsIssueList);
        goodsDetailVO.setGoodsSpecificationList(goodsSpecificationVOList);
        goodsDetailVO.setProductList(productList);

        //TODO 当前用户是否收藏
        //TODO 记录用户足迹
        return goodsDetailVO;
    }

    @Override
    public List<GoodsListVO> queryRelatedGoods(Integer goodsId) {

        List<RelatedGoods> relatedGoodsList = relatedGoodsMapper.select(new RelatedGoods().setGoodsId(goodsId));
        List<GoodsListVO> goodsList = null;

        if (relatedGoodsList.isEmpty()) {
            //查找同分类下的商品
            Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
            PageHelper.startPage(1, 8);
            goodsList = goodsMapper.select(new Goods().setCategoryId(goods.getCategoryId())).stream()
                    .map(GoodsListVO::new)
                    .collect(Collectors.toList());
        } else {
            List<Integer> goodsIdList = relatedGoodsList.stream()
                    .map(RelatedGoods::getGoodsId)
                    .collect(Collectors.toList());
            PageHelper.startPage(1, 8);
            goodsList = goodsMapper.selectByIdIn(goodsIdList).stream()
                    .map(GoodsListVO::new)
                    .collect(Collectors.toList());
        }
        return goodsList;
    }

    @Override
    public GoodsCategoryVO queryGoodsCategory(Integer categoryId) {
        Category currentCategory = categoryMapper.selectByPrimaryKey(categoryId);
        if (currentCategory == null) {
            return null;
        }
        Category parentCategory = categoryMapper.selectByPrimaryKey(currentCategory.getParentId());
        List<Category> brotherCategory = categoryMapper.select(new Category().setParentId(currentCategory.getParentId()));
        return new GoodsCategoryVO(currentCategory, parentCategory, brotherCategory);
    }
}
