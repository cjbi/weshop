package tech.wetech.weshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.bo.GoodsSpecificationBO;
import tech.wetech.weshop.mapper.GoodsSpecificationMapper;
import tech.wetech.weshop.po.GoodsSpecification;
import tech.wetech.weshop.service.GoodsSpecificationService;
import tech.wetech.weshop.vo.GoodsDetailVO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsSpecificationServiceImpl extends BaseService<GoodsSpecification> implements GoodsSpecificationService {

}
