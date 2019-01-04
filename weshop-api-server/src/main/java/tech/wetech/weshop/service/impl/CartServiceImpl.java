package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.wetech.weshop.enums.ResultCodeEnum;
import tech.wetech.weshop.exception.BizException;
import tech.wetech.weshop.mapper.*;
import tech.wetech.weshop.po.*;
import tech.wetech.weshop.service.CartService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.vo.CartCheckoutVO;
import tech.wetech.weshop.vo.CartResultVO;
import tech.wetech.weshop.vo.CartParamVO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl extends BaseService<Cart> implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private UserCouponMapper userCouponMapper;

    @Autowired
    private GoodsSpecificationMapper goodsSpecificationMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public CartResultVO getCart() {
        List<Cart> cartList = cartMapper.select(new Cart() {{
            setUserId(Constants.CURRENT_USER_ID);
            setSessionId(Constants.SESSION_ID);
        }});
        CartResultVO.CartTotalVO cartTotalVO = new CartResultVO.CartTotalVO();

        Integer goodsCount = 0;
        BigDecimal goodsAmount = BigDecimal.ZERO;
        Integer checkedGoodsCount = 0;
        BigDecimal checkedGoodsAmount = BigDecimal.ZERO;
        for (Cart cart : cartList) {
            goodsCount += cart.getNumber();
            //goodsAmount = goodsAmount + retailPrice * number
            goodsAmount = goodsAmount.add(
                    cart.getRetailPrice().multiply(new BigDecimal(cart.getNumber()))
            );
            if (cart.getChecked()) {
                checkedGoodsCount += cart.getNumber();
                //checkedGoodsAmount = checkedGoodsAmount + retailPrice * number
                checkedGoodsAmount = checkedGoodsAmount.add(
                        cart.getRetailPrice().multiply(new BigDecimal(cart.getNumber())))
                ;
            }
        }

        cartTotalVO.setGoodsCount(goodsCount)
                .setGoodsAmount(goodsAmount)
                .setCheckedGoodsCount(checkedGoodsCount)
                .setCheckedGoodsAmount(checkedGoodsAmount);
        return new CartResultVO(cartList, cartTotalVO);
    }

    @Override
    @Transactional
    public void addGoodsToCart(CartParamVO cartParamVO) {
        Goods goods = goodsMapper.selectByPrimaryKey(cartParamVO.getGoodsId());
        if (goods == null || goods.getDelete()) {
            //商品已下架
            throw new BizException(ResultCodeEnum.GOODS_HAVE_BEEN_TAKEN_OFF_THE_SHELVES);
        }
        Product product = productMapper.selectOne(new Product() {{
            setGoodsId(cartParamVO.getGoodsId());
            setId(cartParamVO.getProductId());
        }});
        if (product == null || product.getGoodsNumber() < cartParamVO.getNumber()) {
            //库存不足
            throw new BizException(ResultCodeEnum.UNDER_STOCK);
        }
        Cart cart = cartMapper.selectOne(new Cart() {{
            setGoodsId(cartParamVO.getGoodsId());
            setProductId(cartParamVO.getProductId());
        }});
        if (cart == null) {
            // 判断购物车中是否存在此规格商品
            List<String> goodsSpecificationValueList = new LinkedList<>();
            if (product.getGoodsSpecificationIds() != null) {
                List<Integer> specificationIdList = Arrays.stream(product.getGoodsSpecificationIds().split("_"))
                        .filter(id -> id.length() > 0)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
                if (!specificationIdList.isEmpty()) {
                    goodsSpecificationValueList = goodsSpecificationMapper.selectValueByGoodsIdAndIdIn(cartParamVO.getGoodsId(), specificationIdList);
                }
            }
            Cart cartData = new Cart()
                    .setGoodsId(cartParamVO.getGoodsId())
                    .setProductId(cartParamVO.getProductId())
                    .setGoodsSn(product.getGoodsSn())
                    .setGoodsName(goods.getName())
                    .setListPicUrl(goods.getListPicUrl())
                    .setNumber(cartParamVO.getNumber().shortValue())
                    .setSessionId("1")
                    .setUserId(1)
                    .setRetailPrice(product.getRetailPrice())
                    .setMarketPrice(product.getRetailPrice())
                    .setGoodsSpecifitionNameValue(
                            goodsSpecificationValueList.stream()
                                    .collect(Collectors.joining(";"))
                    )
                    .setGoodsSpecifitionIds(product.getGoodsSpecificationIds())
                    .setChecked(true);
            cartMapper.insertSelective(cartData);
        } else {
            // 如果已经存在购物车中，则数量增加
            if (product.getGoodsNumber() < (cartParamVO.getNumber() + cart.getNumber())) {
                throw new BizException(ResultCodeEnum.UNDER_STOCK);
            }
            cartMapper.incrementNumberById(cart.getId());
        }

    }

    @Override
    @Transactional
    public void updateGoods(CartParamVO cartParamVO) {
        // 取得规格的信息,判断规格库存
        Product product = productMapper.selectOne(new Product() {{
            setGoodsId(cartParamVO.getGoodsId());
            setId(cartParamVO.getProductId());
        }});
        if (product == null || product.getGoodsNumber() < cartParamVO.getNumber()) {
            //库存不足
            throw new BizException(ResultCodeEnum.UNDER_STOCK);
        }
        // 判断是否已经存在product_id购物车商品
        Cart cart = cartMapper.selectByPrimaryKey(cartParamVO.getId());
        if (cart.getProductId().equals(cartParamVO.getProductId())) {
            // 只是更新number
            cartMapper.updateByPrimaryKeySelective(new Cart()
                    .setNumber(cartParamVO.getNumber().shortValue())
                    .setId(cartParamVO.getId())
            );
            return;
        }
        Cart newCartInfo = cartMapper.selectOne(
                new Cart()
                        .setUserId(Constants.CURRENT_USER_ID)
                        .setSessionId(Constants.SESSION_ID)
                        .setGoodsId(cartParamVO.getGoodsId())
                        .setProductId(cartParamVO.getProductId())
        );
        if (newCartInfo == null) {
            //直接更新原来的cartInfo
            // 判断购物车中是否存在此规格商品
            List<String> goodsSpecificationValueList = new LinkedList<>();
            if (product.getGoodsSpecificationIds() != null) {
                List<Integer> specificationIdList = Arrays.stream(product.getGoodsSpecificationIds()
                        .split("_"))
                        .filter(id -> id.length() > 0)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
                if (!specificationIdList.isEmpty()) {
                    goodsSpecificationValueList = goodsSpecificationMapper.selectValueByGoodsIdAndIdIn(cartParamVO.getGoodsId(), specificationIdList);
                }
            }
            Cart cartData = new Cart()
                    .setId(cartParamVO.getId())
                    .setNumber(cartParamVO.getNumber().shortValue())
                    .setGoodsSpecifitionNameValue(
                            goodsSpecificationValueList.stream()
                                    .collect(Collectors.joining(";"))
                    )
                    .setGoodsSpecifitionIds(product.getGoodsSpecificationIds())
                    .setRetailPrice(product.getRetailPrice())
                    .setMarketPrice(product.getRetailPrice())
                    .setProductId(cartParamVO.getProductId())
                    .setGoodsSn(product.getGoodsSn());
            cartMapper.updateByPrimaryKeySelective(cartData);
        } else {
            // 合并购物车已有的product信息，删除已有的数据
            Integer newNumber = cartParamVO.getNumber() + newCartInfo.getNumber();
            if (product == null || product.getGoodsNumber() < newNumber) {
                //库存不足
                throw new BizException(ResultCodeEnum.UNDER_STOCK);
            }
            cartMapper.deleteByPrimaryKey(newCartInfo.getId());
            Cart cartData = new Cart()
                    .setId(cartParamVO.getId())
                    .setNumber(newNumber.shortValue())
                    .setGoodsSpecifitionNameValue(newCartInfo.getGoodsSpecifitionNameValue())
                    .setGoodsSpecifitionIds(newCartInfo.getGoodsSpecifitionIds())
                    .setRetailPrice(product.getRetailPrice())
                    .setMarketPrice(product.getRetailPrice())
                    .setProductId(cartParamVO.getProductId())
                    .setGoodsSn(product.getGoodsSn());
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
            checkedAddress = addressMapper.selectOne(new Address().setUserId(1).setDefault(true));
        }

        CartCheckoutVO.CheckedAddressVO checkedAddressVO = null;
        if (checkedAddress != null) {
            checkedAddressVO = new CartCheckoutVO.CheckedAddressVO(checkedAddress)
                    .setProvinceName(
                            regionMapper.selectNameById(checkedAddress.getProvinceId().intValue())
                    )
                    .setCityName(
                            regionMapper.selectNameById(checkedAddress.getProvinceId().intValue())
                    )
                    .setDistrictName(
                            regionMapper.selectNameById(checkedAddress.getDistrictId().intValue())
                    )
                    .setFullRegion(
                            checkedAddressVO.getProvinceName() + checkedAddressVO.getCityName() + checkedAddressVO.getDistrictName()
                    );
        }
        // 根据收货地址计算运费，未实现
        BigDecimal freightPrice = BigDecimal.ZERO;

        CartResultVO cartData = this.getCart();
        List<Cart> checkedGoodsList = cartData.getCartList().stream()
                .filter(Cart::getChecked)
                .collect(Collectors.toList());

        // 获取可用的优惠券信息
        List<UserCoupon> userCouponList = userCouponMapper.select(new UserCoupon() {{
            setUserId(Constants.CURRENT_USER_ID);
        }});
        BigDecimal couponPrice = BigDecimal.ZERO;

        //计算订单的费用

        //商品总价
        BigDecimal goodsTotalPrice = cartData.getCartTotal().getCheckedGoodsAmount();
        BigDecimal orderTotalPrice = cartData.getCartTotal().getCheckedGoodsAmount()
                .add(freightPrice)
                .subtract(couponPrice);

        //减去其它支付的金额后，要实际支付的金额
        BigDecimal actualPrice = orderTotalPrice
                .subtract(new BigDecimal(0.00));

        cartCheckoutVO.setCheckedAddress(checkedAddressVO);
        cartCheckoutVO.setFreightPrice(freightPrice);
        cartCheckoutVO.setCheckedCoupon(null);
        cartCheckoutVO.setCouponList(userCouponList);
        cartCheckoutVO.setCouponPrice(couponPrice);
        cartCheckoutVO.setCheckedGoodsList(checkedGoodsList);
        cartCheckoutVO.setGoodsTotalPrice(goodsTotalPrice);
        cartCheckoutVO.setOrderTotalPrice(orderTotalPrice);
        cartCheckoutVO.setActualPrice(actualPrice);
        return cartCheckoutVO;
    }

}
