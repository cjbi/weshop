package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.PageInfoVO;

import java.util.Arrays;

/**
 * @author cjbi
 */
public abstract class BaseController<T> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IService<T> service;

    public BaseController() {
    }

    @GetMapping("/list")
    public Result<PageInfoVO<T>> queryPageInfo(T entity, Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = Constants.DEFAULT_PAGE_NUM;
        }
        if (pageSize == null) {
            pageSize = Constants.DEFAULT_PAGE_SIZE;
        }
        PageInfo pageInfo = service.queryPageInfo(entity, pageNum, pageSize);
        PageInfoVO pageInfoVO = new PageInfoVO(pageInfo);
        return Result.success(pageInfoVO);
    }

    @PostMapping("/create")
    public Result create(@RequestBody T entity) {
        service.create(entity);
        return Result.success();
    }

    @PostMapping("/update")
    public Result update(@RequestBody T entity) {
        service.updateNotNull(entity);
        return Result.success();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer[] userIds) {
        Arrays.stream(userIds).forEach(userId -> service.deleteById(userId));
        return Result.success(userIds);
    }

}
