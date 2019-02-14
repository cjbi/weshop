package tech.wetech.weshop.web;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.utils.Result;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author cjbi@outlook.com
 */
@Validated
public abstract class BaseCrudController<T> extends BaseController {

    @Autowired
    protected IService<T> service;

    @GetMapping("/list")
    @ApiOperation("分页查询数据")
    public Result queryList(T entity, PageQuery pageQuery) {
        List<T> list = service.queryPageList(entity, pageQuery);
        return Result.success(service.queryPageList(entity, pageQuery))
                .addExtraIfTrue(pageQuery.isCountSql(), "total", ((Page) list).getTotal());
    }

    @GetMapping
    @ApiOperation("查询单条数据")
    public Result query(@NotNull @RequestParam("id") Object id) {
        return Result.success(service.queryById(id));
    }

    @PostMapping("/create")
    @ApiOperation("新增数据")
    public Result create(@RequestBody @Validated T entity) {
        service.create(entity);
        return Result.success();
    }

    @PostMapping("/update")
    @ApiOperation("更新数据")
    public Result update(@RequestBody @Validated T entity) {
        service.updateNotNull(entity);
        return Result.success();
    }

    @PostMapping("/delete")
    @ApiOperation("删除数据")
    public Result delete(@NotNull @RequestParam("id") Object id) {
        service.deleteById(id);
        return Result.success();
    }

    @PostMapping("/delete-batch")
    @ApiOperation("删除多条数据")
    public Result deleteBatchByIds(@RequestBody @NotNull Object[] ids) {
        Stream.of(ids).parallel().forEach(id -> service.deleteById(id));
        return Result.success();
    }

}
