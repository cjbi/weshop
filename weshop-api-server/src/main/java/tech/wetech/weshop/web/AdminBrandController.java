package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.domain.Brand;
import tech.wetech.weshop.query.BrandPageQuery;
import tech.wetech.weshop.service.BrandService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CreateBrandFormVO;
import tech.wetech.weshop.vo.PageInfoVO;
import tech.wetech.weshop.vo.UpdateBrandFormVO;

import javax.validation.Valid;
import java.util.Arrays;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/brand")
public class AdminBrandController extends BaseController<Brand> {

}
