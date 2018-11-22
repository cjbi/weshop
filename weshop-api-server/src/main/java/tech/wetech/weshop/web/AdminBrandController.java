package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
public class AdminBrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/list")
    public Result<PageInfoVO> queryPageInfo(BrandPageQuery brandPageQuery) {
        PageInfo pageInfo = brandService.queryBrandPageInfo(brandPageQuery);
        PageInfoVO pageInfoVO = new PageInfoVO(pageInfo);
        return Result.success(pageInfoVO);
    }

    @PostMapping("/create")
    public Result createBrand(@Valid @RequestBody CreateBrandFormVO createBrandFormVO) {
        brandService.createBrand(createBrandFormVO);
        return Result.success();
    }

    @PostMapping("/update")
    public Result updateBrand(@Valid @RequestBody UpdateBrandFormVO updateBrandFormVO) {
        brandService.updateBrand(updateBrandFormVO);
        return Result.success();
    }

    @PostMapping("/delete")
    public Result deleteBrand(@RequestBody Integer[] userIds) {
        Arrays.stream(userIds).forEach(userId -> brandService.deleteBrand(userId));
        return Result.success();
    }

}
