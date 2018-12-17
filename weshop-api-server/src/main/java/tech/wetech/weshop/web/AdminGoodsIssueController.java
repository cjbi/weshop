package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.domain.GoodsIssue;
import tech.wetech.weshop.query.GoodsIssuePageQuery;
import tech.wetech.weshop.service.GoodsIssueService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CreateGoodsIssueFormVO;
import tech.wetech.weshop.vo.PageInfoVO;
import tech.wetech.weshop.vo.UpdateGoodsIssueFormVO;

import java.util.Arrays;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/goods-issue")
public class AdminGoodsIssueController extends BaseController<GoodsIssue> {

}
