package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.query.BrandPageQuery;
import tech.wetech.weshop.service.BrandService;
import tech.wetech.weshop.vo.PageInfoVO;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/brand")
public class AdminBrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/list")
    public Result<PageInfoVO> queryPageInfo(BrandPageQuery brandPageQuery) {
        PageInfo pageInfo = brandService.queryBrandPageInfo(brandPageQuery);
        PageInfoVO pageInfoVO = new PageInfoVO(pageInfo);
        return Result.success(pageInfoVO);
    }

}
