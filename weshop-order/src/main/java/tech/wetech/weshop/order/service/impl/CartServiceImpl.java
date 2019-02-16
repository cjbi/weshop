package tech.wetech.weshop.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.wetech.weshop.enums.ResultCodeEnum;
import tech.wetech.weshop.exception.BizException;
import tech.wetech.weshop.goods.api.GoodsApi;
import tech.wetech.weshop.goods.api.GoodsSpecificationApi;
import tech.wetech.weshop.goods.api.ProductApi;
import tech.wetech.weshop.goods.po.Goods;
import tech.wetech.weshop.goods.po.Product;
import tech.wetech.weshop.order.dto.CartCheckoutDTO;
import tech.wetech.weshop.order.dto.CartParamDTO;
import tech.wetech.weshop.order.dto.CartResultDTO;
import tech.wetech.weshop.order.mapper.CartMapper;
import tech.wetech.weshop.order.po.Cart;
import tech.wetech.weshop.order.service.CartService;
import tech.wetech.weshop.service.BaseService;
import tech.wetech.weshop.user.api.AddressApi;
import tech.wetech.weshop.user.api.RegionApi;
import tech.wetech.weshop.user.api.UserCouponApi;
import tech.wetech.weshop.user.po.Address;
import tech.wetech.weshop.user.po.UserCoupon;
import tech.wetech.weshop.utils.Constants;

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
    private UserCouponApi userCouponApi;

    @Autowired
    private AddressApi addressApi;

    @Autowired
    private RegionApi regionApi;

    @Autowired
    private GoodsApi goodsApi;

    @Autowired
    private GoodsSpecificationApi goodsSpecificationApi;

    @Autowired
    private ProductApi productApi;

    @Override
    public CartResultDTO getCart() {
        List<Cart> cartList = cartMapper.select(new Cart() {{
            setUserId(Constants.CURRENT_USER_ID);
            setSessionId(Constants.SESSION_ID);
        }});
        CartResultDTO.CartTotalVO cartTotalVO = new CartResultDTO.CartTotalVO();

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
        return new CartResultDTO(cartList, cartTotalVO);
    }

    @Override
    @Transactional
    public void addGoodsToCart(CartParamDTO cartParamDTO) {
        Goods goods = goodsApi.queryById(cartParamDTO.getGoodsId()).getData();
        if (goods == null || goods.getDelete()) {
            //商品已下架
            throw new BizException(ResultCodeEnum.GOODS_HAVE_BEEN_TAKEN_OFF_THE_SHELVES);
        }
        Product product = productApi.queryOne(new Product() {{
            setGoodsId(cartParamDTO.getGoodsId());
            setId(cartParamDTO.getProductId());
        }}).getData();
        if (product == null || product.getGoodsNumber() < cartParamDTO.getNumber()) {
            //库存不足
            throw new BizException(ResultCodeEnum.UNDER_STOCK);
        }
        Cart cart = cartMapper.selectOne(new Cart() {{
            setGoodsId(cartParamDTO.getGoodsId());
            setProductId(cartParamDTO.getProductId());
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
                    goodsSpecificationValueList = goodsSpecificationApi.queryValueByGoodsIdAndIdIn(cartParamDTO.getGoodsId(), specificationIdList).getData();
                }
            }
            Cart cartData = new Cart()
                    .setGoodsId(cartParamDTO.getGoodsId())
                    .setProductId(cartParamDTO.getProductId())
                    .setGoodsSn(product.getGoodsSn())
                    .setGoodsName(goods.getName())
                    .setListPicUrl(goods.getListPicUrl())
                    .setNumber(cartParamDTO.getNumber().shortValue())
                    .setSessionId("1")
                    .setUserId(1)
                    .setRetailPrice(product.getRetailPrice())
                    .setMarketPrice(product.getRetailPrice())
                    .setGoodsSpecificationNameValue(
                            goodsSpecificationValueList.stream()
                                    .collect(Collectors.joining(";"))
                    )
                    .setGoodsSpecificationIds(product.getGoodsSpecificationIds())
                    .setChecked(true);
            cartMapper.insertSelective(cartData);
        } else {
            // 如果已经存在购物车中，则数量增加
            if (product.getGoodsNumber() < (cartParamDTO.getNumber() + cart.getNumber())) {
                throw new BizException(ResultCodeEnum.UNDER_STOCK);
            }
            cartMapper.incrementNumberById(cart.getId());
        }

    }

    @Override
    @Transactional
    public void updateGoods(CartParamDTO cartParamDTO) {
        // 取得规格的信息,判断规格库存
        Product product = productApi.queryOne(new Product()
                .setGoodsId(cartParamDTO.getGoodsId())
                .setId(cartParamDTO.getProductId())
        ).getData();
        if (product == null || product.getGoodsNumber() < cartParamDTO.getNumber()) {
            //库存不足
            throw new BizException(ResultCodeEnum.UNDER_STOCK);
        }
        // 判断是否已经存在product_id购物车商品
        Cart cart = cartMapper.selectByPrimaryKey(cartParamDTO.getId());
        if (cart.getProductId().equals(cartParamDTO.getProductId())) {
            // 只是更新number
            cartMapper.updateByPrimaryKeySelective(new Cart()
                    .setNumber(cartParamDTO.getNumber().shortValue())
                    .setId(cartParamDTO.getId())
            );
            return;
        }
        Cart newCartInfo = cartMapper.selectOne(
                new Cart()
                        .setUserId(Constants.CURRENT_USER_ID)
                        .setSessionId(Constants.SESSION_ID)
                        .setGoodsId(cartParamDTO.getGoodsId())
                        .setProductId(cartParamDTO.getProductId())
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
                    goodsSpecificationValueList = goodsSpecificationApi.queryValueByGoodsIdAndIdIn(cartParamDTO.getGoodsId(), specificationIdList).getData();
                }
            }
            Cart cartData = new Cart()
                    .setId(cartParamDTO.getId())
                    .setNumber(cartParamDTO.getNumber().shortValue())
                    .setGoodsSpecificationNameValue(
                            goodsSpecificationValueList.stream()
                                    .collect(Collectors.joining(";"))
                    )
                    .setGoodsSpecificationIds(product.getGoodsSpecificationIds())
                    .setRetailPrice(product.getRetailPrice())
                    .setMarketPrice(product.getRetailPrice())
                    .setProductId(cartParamDTO.getProductId())
                    .setGoodsSn(product.getGoodsSn());
            cartMapper.updateByPrimaryKeySelective(cartData);
        } else {
            // 合并购物车已有的product信息，删除已有的数据
            Integer newNumber = cartParamDTO.getNumber() + newCartInfo.getNumber();
            if (product == null || product.getGoodsNumber() < newNumber) {
                //库存不足
                throw new BizException(ResultCodeEnum.UNDER_STOCK);
            }
            cartMapper.deleteByPrimaryKey(newCartInfo.getId());
            Cart cartData = new Cart()
                    .setId(cartParamDTO.getId())
                    .setNumber(newNumber.shortValue())
                    .setGoodsSpecificationNameValue(newCartInfo.getGoodsSpecificationNameValue())
                    .setGoodsSpecificationIds(newCartInfo.getGoodsSpecificationIds())
                    .setRetailPrice(product.getRetailPrice())
                    .setMarketPrice(product.getRetailPrice())
                    .setProductId(cartParamDTO.getProductId())
                    .setGoodsSn(product.getGoodsSn());
            cartMapper.updateByPrimaryKeySelective(cartData);
        }


    }

    @Override
    public CartCheckoutDTO checkoutCart(Integer addressId, Integer couponId) {
        CartCheckoutDTO cartCheckoutDTO = new CartCheckoutDTO();
        //选择收货地址
        Address checkedAddress = null;
        if (addressId != null) {
            checkedAddress = addressApi.queryOne(new Address()
                    .setId(Constants.ADDRESS_ID)
                    .setUserId(Constants.CURRENT_USER_ID)
            ).getData();
        } else {
            checkedAddress = addressApi.queryOne(new Address().setUserId(1).setIsDefault(true)).getData();
        }

        CartCheckoutDTO.CheckedAddressVO checkedAddressVO = null;
        if (checkedAddress != null) {
            checkedAddressVO = new CartCheckoutDTO.CheckedAddressVO(checkedAddress)
                    .setProvinceName(
                            regionApi.queryNameById(checkedAddress.getProvinceId()).getData()
                    )
                    .setCityName(
                            regionApi.queryNameById(checkedAddress.getCityId()).getData()
                    )
                    .setDistrictName(
                            regionApi.queryNameById(checkedAddress.getDistrictId()).getData()
                    );

            checkedAddressVO.setFullRegion(
                    checkedAddressVO.getProvinceName() + checkedAddressVO.getCityName() + checkedAddressVO.getDistrictName()
            );
        }
        // 根据收货地址计算运费，未实现
        BigDecimal freightPrice = BigDecimal.ZERO;

        CartResultDTO cartData = this.getCart();
        List<Cart> checkedGoodsList = cartData.getCartList().stream()
                .filter(Cart::getChecked)
                .collect(Collectors.toList());

        // 获取可用的优惠券信息
        List<UserCoupon> userCouponList = userCouponApi.queryList(new UserCoupon() {{
            setUserId(Constants.CURRENT_USER_ID);
        }}).getData();
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

        cartCheckoutDTO.setCheckedAddress(checkedAddressVO);
        cartCheckoutDTO.setFreightPrice(freightPrice);
        cartCheckoutDTO.setCheckedCoupon(null);
        cartCheckoutDTO.setCouponList(userCouponList);
        cartCheckoutDTO.setCouponPrice(couponPrice);
        cartCheckoutDTO.setCheckedGoodsList(checkedGoodsList);
        cartCheckoutDTO.setGoodsTotalPrice(goodsTotalPrice);
        cartCheckoutDTO.setOrderTotalPrice(orderTotalPrice);
        cartCheckoutDTO.setActualPrice(actualPrice);
        return cartCheckoutDTO;
    }

}
