package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.core.utils.Result;
import tech.wetech.weshop.query.AddressPageQuery;
import tech.wetech.weshop.service.AddressService;
import tech.wetech.weshop.vo.AddressPageVO;
import tech.wetech.weshop.vo.Pagination;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/address")
public class AdminAddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public Result<AddressPageVO> queryAddressPageInfo(AddressPageQuery addressPageQuery) {
        PageInfo pageInfo = addressService.queryAddressPageInfo(addressPageQuery);
        Pagination pagination = new Pagination(pageInfo);
        AddressPageVO addressPageVO = new AddressPageVO();
        addressPageVO.setList(pageInfo.getList());
        addressPageVO.setPagination(pagination);

        return Result.success(addressPageVO);
    }

}
