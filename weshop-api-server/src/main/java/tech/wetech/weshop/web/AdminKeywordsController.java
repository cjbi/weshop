package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.domain.Keywords;
import tech.wetech.weshop.query.KeywordsPageQuery;
import tech.wetech.weshop.service.KeywordsService;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.CreateKeywordsFormVO;
import tech.wetech.weshop.vo.PageInfoVO;
import tech.wetech.weshop.vo.UpdateKeywordsFormVO;

import java.util.Arrays;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/keywords")
public class AdminKeywordsController extends BaseController<Keywords> {

}
