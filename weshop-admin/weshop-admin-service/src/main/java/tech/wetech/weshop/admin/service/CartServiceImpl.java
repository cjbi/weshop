package tech.wetech.weshop.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.wetech.weshop.enums.ResultCodeEnum;
import tech.wetech.weshop.exception.BizException;
import tech.wetech.weshop.mapper.*;
import tech.wetech.weshop.service.BaseService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.admin.dto.CartCheckoutDTO;
import tech.wetech.weshop.admin.dto.CartResultDTO;
import tech.wetech.weshop.admin.dto.CartParamDTO;

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
        Goods goods = goodsMapper.selectByPrimaryKey(cartParamDTO.getGoodsId());
        if (goods == null || goods.getDelete()) {
            //商品已下架
            throw new BizException(ResultCodeEnum.GOODS_HAVE_BEEN_TAKEN_OFF_THE_SHELVES);
        }
        Product product = productMapper.selectOne(new Product() {{
            setGoodsId(cartParamDTO.getGoodsId());
            setId(cartParamDTO.getProductId());
        }});
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
                    goodsSpecificationValueList = goodsSpecificationMapper.selectValueByGoodsIdAndIdIn(cartParamDTO.getGoodsId(), specificationIdList);
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
        Product product = productMapper.selectOne(new Product() {{
            setGoodsId(cartParamDTO.getGoodsId());
            setId(cartParamDTO.getProductId());
        }});
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
                    goodsSpecificationValueList = goodsSpecificationMapper.selectValueByGoodsIdAndIdIn(cartParamDTO.getGoodsId(), specificationIdList);
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
            checkedAddress = addressMapper.selectOne(new Address() {{
                setId(Constants.ADDRESS_ID);
                setUserId(Constants.CURRENT_USER_ID);
            }});
        } else {
            checkedAddress = addressMapper.selectOne(new Address().setUserId(1).setIsDefault(true));
        }

        CartCheckoutDTO.CheckedAddressVO checkedAddressVO = null;
        if (checkedAddress != null) {
            checkedAddressVO = new CartCheckoutDTO.CheckedAddressVO(checkedAddress)
                    .setProvinceName(
                            regionMapper.selectNameById(checkedAddress.getProvinceId())
                    )
                    .setCityName(
                            regionMapper.selectNameById(checkedAddress.getCityId())
                    )
                    .setDistrictName(
                            regionMapper.selectNameById(checkedAddress.getDistrictId())
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
