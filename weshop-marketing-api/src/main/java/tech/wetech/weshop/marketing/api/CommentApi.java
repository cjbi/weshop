package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.marketing.dto.CommentCountDTO;
import tech.wetech.weshop.marketing.dto.CommentResultDTO;
import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.query.CommentQuery;

import java.util.List;

@FeignClient(value = "weshop-marketing", path = "comment")
public interface CommentApi extends Api<Comment> {

    @RequestMapping(value = "/queryList2", method = RequestMethod.GET)
    List<CommentResultDTO> queryList(CommentQuery commentQuery);

    @RequestMapping(value = "/countList", method = RequestMethod.GET)
    CommentCountDTO countList(CommentQuery commentQuery);
}
