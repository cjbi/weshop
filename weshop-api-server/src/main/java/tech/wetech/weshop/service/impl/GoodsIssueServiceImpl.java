package tech.wetech.weshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.wetech.weshop.mapper.GoodsIssueMapper;
import tech.wetech.weshop.domain.GoodsIssue;
import tech.wetech.weshop.query.GoodsIssuePageQuery;
import tech.wetech.weshop.service.GoodsIssueService;
import tech.wetech.weshop.vo.CreateGoodsIssueFormVO;
import tech.wetech.weshop.vo.UpdateGoodsIssueFormVO;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * @author cjbi
 */
@Service
public class GoodsIssueServiceImpl extends BaseService<GoodsIssue> implements GoodsIssueService {

}
