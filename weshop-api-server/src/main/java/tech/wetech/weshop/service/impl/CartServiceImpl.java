package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.wetech.weshop.enums.ResultCodeEnum;
import tech.wetech.weshop.exception.BizException;
import tech.wetech.weshop.mapper.CartMapper;
import tech.wetech.weshop.mapper.GoodsMapper;
import tech.wetech.weshop.mapper.ProductMapper;
import tech.wetech.weshop.po.Cart;
import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.po.Product;
import tech.wetech.weshop.service.CartService;
import tech.wetech.weshop.vo.AddToCartVO;

@Service
public class CartServiceImpl extends BaseService<Cart> implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public void addToCart(AddToCartVO addToCartVO) {
        Goods goods = goodsMapper.selectByPrimaryKey(addToCartVO.getGoodsId());
        if (goods == null || goods.getIsDelete()) {
            //商品已下架
            throw new BizException(ResultCodeEnum.GOODS_HAVE_BEEN_TAKEN_OFF_THE_SHELVES);
        }
        Product product = productMapper.selectOne(new Product() {{
            setGoodsId(addToCartVO.getGoodsId());
            setId(addToCartVO.getProductId());
        }});
        if (product == null || product.getGoodsNumber() < addToCartVO.getNumber()) {
            //库存不足
            throw new BizException(ResultCodeEnum.UNDER_STOCK);
        }
        Cart cart = cartMapper.selectOne(new Cart() {{
            setGoodsId(addToCartVO.getGoodsId());
            setProductId(addToCartVO.getProductId());
        }});
        // 判断购物车中是否存在此规格商品
        if (cart != null) {
            if (product.getGoodsSpecificationIds() != null) {
            }
        }


    }
}
