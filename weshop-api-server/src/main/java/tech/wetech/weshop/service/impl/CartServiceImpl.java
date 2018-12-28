package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.wetech.weshop.enums.ResultCodeEnum;
import tech.wetech.weshop.exception.BizException;
import tech.wetech.weshop.mapper.*;
import tech.wetech.weshop.po.Address;
import tech.wetech.weshop.po.Cart;
import tech.wetech.weshop.po.Goods;
import tech.wetech.weshop.po.Product;
import tech.wetech.weshop.service.CartService;
import tech.wetech.weshop.vo.CartCheckoutVO;
import tech.wetech.weshop.vo.CartGoodsListVO;
import tech.wetech.weshop.vo.CartVO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CartServiceImpl extends BaseService<Cart> implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public CartGoodsListVO queryList() {
        Integer loginUserId = 1;
        String sessionId = "1";
        List<Cart> cartList = cartMapper.select(new Cart() {{
            setUserId(loginUserId);
            setSessionId(sessionId);
        }});
        CartGoodsListVO.CartTotalVO cartTotalVO = new CartGoodsListVO.CartTotalVO();
        Stream<Cart> stream = cartList.stream();
        cartTotalVO.setGoodsCount(
                cartList.size()
        );
        // 使用reduce聚合函数,实现累加器
        cartTotalVO.setGoodsAmount(
                stream.map(Cart::getRetailPrice).reduce(BigDecimal.ZERO, BigDecimal::add)
        );
        cartTotalVO.setCheckedGoodsCount(
                stream.filter(Cart::getChecked).mapToInt(c -> 1).sum()
        );
        cartTotalVO.setCheckedGoodsAmount(
                stream.filter(Cart::getChecked).map(Cart::getRetailPrice).reduce(BigDecimal.ZERO, BigDecimal::add)
        );
        return new CartGoodsListVO(cartList, cartTotalVO);
    }

    @Override
    @Transactional
    public void addToCart(CartVO cartVO) {
        Goods goods = goodsMapper.selectByPrimaryKey(cartVO.getGoodsId());
        if (goods == null || goods.getIsDelete()) {
            //商品已下架
            throw new BizException(ResultCodeEnum.GOODS_HAVE_BEEN_TAKEN_OFF_THE_SHELVES);
        }
        Product product = productMapper.selectOne(new Product() {{
            setGoodsId(cartVO.getGoodsId());
            setId(cartVO.getProductId());
        }});
        if (product == null || product.getGoodsNumber() < cartVO.getNumber()) {
            //库存不足
            throw new BizException(ResultCodeEnum.UNDER_STOCK);
        }
        Cart cart = cartMapper.selectOne(new Cart() {{
            setGoodsId(cartVO.getGoodsId());
            setProductId(cartVO.getProductId());
        }});
        if (cart == null) {
            // 判断购物车中是否存在此规格商品
            List<String> goodsSpecificationValueList = new LinkedList<>();
            if (product.getGoodsSpecificationIds() != null) {
                List<Integer> specificationIdList = Arrays.stream(product.getGoodsSpecificationIds().split("_"))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
                goodsSpecificationValueList = goodsSpecificationMapper.selectValueByGoodsIdAndIdIn(cartVO.getGoodsId(), specificationIdList);
            }
            Cart cartData = new Cart();
            cartData.setGoodsId(cartVO.getGoodsId());
            cartData.setProductId(cartVO.getProductId());
            cartData.setGoodsSn(product.getGoodsSn());
            cartData.setGoodsName(goods.getName());
            cartData.setListPicUrl(goods.getListPicUrl());
            cartData.setNumber(cartVO.getNumber().shortValue());
            cartData.setSessionId("1");
            cartData.setUserId(1);
            cartData.setRetailPrice(product.getRetailPrice());
            cartData.setMarketPrice(product.getRetailPrice());
            cartData.setGoodsSpecifitionNameValue(
                    goodsSpecificationValueList.stream()
                            .collect(Collectors.joining(";"))
            );
            cartData.setGoodsSpecifitionIds(product.getGoodsSpecificationIds());
            cartData.setChecked(true);
            cartMapper.insertSelective(cart);
        } else {
            // 如果已经存在购物车中，则数量增加
            if (product.getGoodsNumber() < (cartVO.getNumber() + cart.getNumber())) {
                throw new BizException(ResultCodeEnum.UNDER_STOCK);
            }
            cartMapper.incrementNumberById(cart.getId());
        }

    }

    @Override
    @Transactional
    public void updateCart(CartVO cartVO) {
        // 取得规格的信息,判断规格库存
        Product product = productMapper.selectOne(new Product() {{
            setGoodsId(cartVO.getGoodsId());
            setId(cartVO.getProductId());
        }});
        if (product == null || product.getGoodsNumber() < cartVO.getNumber()) {
            //库存不足
            throw new BizException(ResultCodeEnum.UNDER_STOCK);
        }
        // 判断是否已经存在product_id购物车商品
        Cart cart = cartMapper.selectByPrimaryKey(cartVO.getId());
        if (cart.getProductId().equals(cartVO.getProductId())) {
            // 只是更新number
            cartMapper.updateByPrimaryKeySelective(new Cart() {{
                setNumber(cartVO.getNumber().shortValue());
                setId(cartVO.getId());
            }});
            return;
        }
        Cart newCartInfo = cartMapper.selectOne(new Cart() {{
            setUserId(1);
            setSessionId("1");
            setGoodsId(cartVO.getGoodsId());
            setProductId(cartVO.getProductId());
        }});
        if (newCartInfo == null) {
            //直接更新原来的cartInfo
            // 判断购物车中是否存在此规格商品
            List<String> goodsSpecificationValueList = new LinkedList<>();
            if (product.getGoodsSpecificationIds() != null) {
                List<Integer> specificationIdList = Arrays.stream(product.getGoodsSpecificationIds().split("_"))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
                goodsSpecificationValueList = goodsSpecificationMapper.selectValueByGoodsIdAndIdIn(cartVO.getGoodsId(), specificationIdList);
            }
            Cart cartData = new Cart();
            cartData.setId(cartData.getId());
            cartData.setNumber(cartVO.getNumber().shortValue());
            cartData.setGoodsSpecifitionNameValue(
                    goodsSpecificationValueList.stream()
                            .collect(Collectors.joining(";"))
            );
            cartData.setGoodsSpecifitionIds(product.getGoodsSpecificationIds());
            cartData.setRetailPrice(product.getRetailPrice());
            cartData.setMarketPrice(product.getRetailPrice());
            cartData.setProductId(cartVO.getProductId());
            cartData.setGoodsSn(product.getGoodsSn());
            cartMapper.updateByPrimaryKeySelective(cartData);
        } else {
            // 合并购物车已有的product信息，删除已有的数据
            Integer newNumber = cartVO.getNumber() + newCartInfo.getNumber();
            if (product == null || product.getGoodsNumber() < newNumber) {
                //库存不足
                throw new BizException(ResultCodeEnum.UNDER_STOCK);
            }
            cartMapper.deleteByPrimaryKey(newCartInfo.getId());
            Cart cartData = new Cart();
            cartData.setId(cartVO.getId());
            cartData.setNumber(newNumber.shortValue());
            cartData.setGoodsSpecifitionNameValue(newCartInfo.getGoodsSpecifitionNameValue());
            cartData.setGoodsSpecifitionIds(newCartInfo.getGoodsSpecifitionIds());
            cartData.setRetailPrice(product.getRetailPrice());
            cartData.setMarketPrice(product.getRetailPrice());
            cartData.setProductId(cartVO.getProductId());
            cartData.setGoodsSn(product.getGoodsSn());
            cartMapper.updateByPrimaryKeySelective(cartData);
        }


    }

    @Override
    public CartCheckoutVO checkoutCart(Integer addressId, Integer couponId) {
        CartCheckoutVO cartCheckoutVO = new CartCheckoutVO();
        //选择收货地址

        Address checkedAddress = null;
        if (addressId != null) {
            checkedAddress = addressMapper.selectOne(new Address() {{
                setId(addressId);
                setUserId(1);
            }});
        } else {
            checkedAddress = addressMapper.selectOne(new Address() {{
                setUserId(1);
                setIsDefault(true);
            }});
        }

        CartCheckoutVO.CheckedAddressVO checkedAddressVO = null;
        if (checkedAddress != null) {
            checkedAddressVO = new CartCheckoutVO.CheckedAddressVO(checkedAddress);
            checkedAddressVO.setProvinceName(
                    regionMapper.selectNameById(checkedAddress.getProvinceId().intValue())
            );
        }
        return null;
    }

}
