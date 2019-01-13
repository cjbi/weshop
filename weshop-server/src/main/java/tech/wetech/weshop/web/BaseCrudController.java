package tech.wetech.weshop.web;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.utils.Result;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * @author cjbi
 */
@Validated
public abstract class BaseCrudController<T> extends BaseController {

    @Autowired
    protected IService<T> service;

    @GetMapping("/list")
    @ApiOperation("分页查询数据")
    public Result queryList(T entity, PageQuery pageQuery) {
        List<T> list = service.queryList(entity, pageQuery);
        return Result.success(service.queryList(entity, pageQuery))
                .addExtraIfTrue(pageQuery.isCountSql(), "total", ((Page) list).getTotal());
    }

    @GetMapping("/{id}")
    @ApiOperation("查询单条数据")
    public Result query(@PathVariable Object id) {
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
    public Result deleteBatchIds(@RequestBody @NotNull Object[] ids) {
        Arrays.stream(ids).parallel().forEach(id -> service.deleteById(id));
        return Result.success();
    }

}
