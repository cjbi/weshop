package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wetech.weshop.core.utils.Result;
import tech.wetech.weshop.query.FeedbackPageQuery;
import tech.wetech.weshop.service.FeedbackService;
import tech.wetech.weshop.vo.FeedbackPageVO;
import tech.wetech.weshop.vo.Pagination;

/**
 * @author cjbi
 */
@RestController
@RequestMapping("/admin/feedback")
public class AdminFeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/list")
    public Result<FeedbackPageVO> queryFeedbackPageInfo(FeedbackPageQuery feedbackPageQuery) {
        PageInfo pageInfo = feedbackService.queryFeedbackPageInfo(feedbackPageQuery);
        Pagination pagination = new Pagination(pageInfo);
        FeedbackPageVO feedbackPageVO = new FeedbackPageVO();
        feedbackPageVO.setList(pageInfo.getList());
        feedbackPageVO.setPagination(pagination);
        return Result.success(feedbackPageVO);
    }

}
