package tech.wetech.weshop.web;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.PageInfoVO;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    public Result<T> query(@PathVariable Object id) {
        return Result.success(service.queryById(id));
    }

    @PostMapping
    public Result create(@RequestBody @Valid T entity) {
        service.create(entity);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody @Valid T entity) {
        service.updateNotNull(entity);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Object id) {
        service.deleteById(id);
        return Result.success();
    }

    @DeleteMapping
    public Result deleteBatchIds(@RequestBody Object[] ids) {
        if (ids != null && ids.length > 0) {
            Arrays.stream(ids).forEach(id -> service.deleteById(id));
        }
        return Result.success();
    }

}
