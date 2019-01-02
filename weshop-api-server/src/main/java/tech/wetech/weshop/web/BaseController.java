package tech.wetech.weshop.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.utils.Constants;
import tech.wetech.weshop.utils.Result;
import tech.wetech.weshop.vo.PageInfoVO;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * @author cjbi
 */
@Validated
public abstract class BaseController<T> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected IService<T> service;

    public BaseController() {
    }

    @GetMapping("/list")
    @ApiOperation("分页查询数据")
    public Result<PageInfoVO<T>> queryPageInfo(T entity, PageQuery pageQuery) {
//        if (pageNum == null) {
//            pageNum = Constants.DEFAULT_PAGE_NUM;
//        }
//        if (pageSize == null) {
//            pageSize = Constants.DEFAULT_PAGE_SIZE;
//        }
        return Result.success(new PageInfoVO<>(service.queryPageInfo(entity, pageQuery)));
    }

    @GetMapping("/{id}")
    @ApiOperation("查询单条数据")
    public Result<T> query(@PathVariable Object id) {
        return Result.success(service.queryById(id));
    }

    @PostMapping
    @ApiOperation("新增数据")
    public Result create(@RequestBody @Validated T entity) {
        service.create(entity);
        return Result.success();
    }

    @PutMapping
    @ApiOperation("更新数据")
    public Result update(@RequestBody @Validated T entity) {
        service.updateNotNull(entity);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除数据")
    public Result delete(@PathVariable Object id) {
        service.deleteById(id);
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation("删除多条数据")
    public Result deleteBatchIds(@RequestBody @NotNull @Min(1) Object[] ids) {
        Arrays.stream(ids).forEach(id -> service.deleteById(id));
        return Result.success();
    }

}
