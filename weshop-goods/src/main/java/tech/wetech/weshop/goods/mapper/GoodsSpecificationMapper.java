package tech.wetech.weshop.goods.mapper;

import org.apache.ibatis.annotations.Param;
import tech.wetech.weshop.common.utils.MyMapper;
import tech.wetech.weshop.goods.dto.GoodsSpecificationDTO;
import tech.wetech.weshop.goods.po.GoodsSpecification;

import java.util.List;

public interface GoodsSpecificationMapper extends MyMapper<GoodsSpecification> {

    List<GoodsSpecificationDTO> selectGoodsDetailSpecificationByGoodsId(Integer goodsId);

    List<String> selectValueByGoodsIdAndIdIn(Integer goodsId, @Param("list") List<Integer> goodsSpecificationIds);
}