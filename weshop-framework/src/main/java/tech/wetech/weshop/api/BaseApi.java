package tech.wetech.weshop.api;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import tech.wetech.weshop.query.PageQuery;
import tech.wetech.weshop.query.PageQueryWrapper;
import tech.wetech.weshop.service.IService;
import tech.wetech.weshop.utils.Result;
import tk.mybatis.mapper.code.Style;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

public abstract class BaseApi<T> implements Api<T> {

    @Autowired
    protected IService<T> service;

    @Override
    public Result<List<T>> queryAll() {
        return Result.success(service.queryAll());
    }

    @Override
    public Result<List<T>> queryList(T entity) {
        return Result.success(service.queryList(entity));
    }

    @Override
    public Result<List<T>> queryPageList(PageQueryWrapper<T> pageQueryWrapper) {
        T data = pageQueryWrapper.getData();
        PageQuery pageQuery = pageQueryWrapper.getPageQuery();
        if (pageQuery.getOrderBy() != null) {
            pageQuery.setOrderBy(StringUtil.convertByStyle(pageQuery.getOrderBy(), Style.camelhump));
        }
        List<T> list = service.queryPageList(data, pageQuery);
        return Result.success(list)
                .addExtraIfTrue(pageQuery.isCountSql(), "total", ((Page) list).getTotal());
    }

    @Override
    public Result<T> queryOne(T entity) {
        return Result.success(service.queryOne(entity));
    }

    @Override
    public Result<T> queryById(Object id) {
        return Result.success(service.queryById(id));
    }

    @Override
    public Result<Integer> create(T entity) {
        return Result.success(service.create(entity));
    }

    @Override
    public Result<Integer> updateAll(T entity) {
        return Result.success(service.updateAll(entity));
    }

    @Override
    public Result<Integer> updateNotNull(T entity) {
        return Result.success(service.updateNotNull(entity));
    }

    @Override
    public Result<Integer> delete(T entity) {
        return Result.success(service.delete(entity));
    }

    @Override
    public Result<Integer> deleteById(Object id) {
        return Result.success(service.deleteById(id));
    }

    @Override
    public Result<Integer> count(T entity) {
        return Result.success(service.count(entity));
    }

    @Override
    public Result<String> sayHello(String name) {
        return Result.success("Hello " + name);
    }
}
