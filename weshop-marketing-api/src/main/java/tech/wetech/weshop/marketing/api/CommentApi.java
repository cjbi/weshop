package tech.wetech.weshop.marketing.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.marketing.dto.CommentCountDTO;
import tech.wetech.weshop.marketing.dto.CommentResultDTO;
import tech.wetech.weshop.marketing.po.Comment;
import tech.wetech.weshop.marketing.query.CommentQuery;
import tech.wetech.weshop.utils.Result;

import java.util.List;

@FeignClient(value = "weshop-marketing", path = "comment")
public interface CommentApi extends Api<Comment> {

    @GetMapping("/queryList2")
    Result<List<CommentResultDTO>> queryList(CommentQuery commentQuery);

    @GetMapping("/countList")
    Result<CommentCountDTO> countList(CommentQuery commentQuery);
}
