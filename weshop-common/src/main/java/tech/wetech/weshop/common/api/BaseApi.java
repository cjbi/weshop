package tech.wetech.weshop.common.api;

import org.springframework.beans.factory.annotation.Autowired;
import tech.wetech.weshop.common.service.IService;
import tech.wetech.weshop.common.utils.Criteria;
import tech.wetech.weshop.common.utils.ResultWrapper;

import java.util.List;

public abstract class BaseApi<T> implements Api<T> {

    @Autowired
    protected IService<T> service;

    @Override
    public ResultWrapper<List<T>> queryAll() {
        return ResultWrapper.success(service.queryAll());
    }

    @Override
    public ResultWrapper<List<T>> queryList(T entity) {
        return ResultWrapper.success(service.queryList(entity));
    }

    @Override
    public ResultWrapper<List<T>> queryByCriteria(Criteria<T, Object> criteria) {
        return ResultWrapper.success(service.queryByCriteria(criteria));
    }

    @Override
    public ResultWrapper<T> queryOneByCriteria(Criteria<T, Object> criteria) {
        return ResultWrapper.success(service.queryOneByCriteria(criteria));
    }

    @Override
    public ResultWrapper<Integer> countByCriteria(Criteria<T, Object> criteria) {
        return ResultWrapper.success(service.countByCriteria(criteria));
    }

    @Override
    public ResultWrapper<T> queryOne(T entity) {
        return ResultWrapper.success(service.queryOne(entity));
    }

    @Override
    public ResultWrapper<T> queryById(Object id) {
        return ResultWrapper.success(service.queryById(id));
    }

    @Override
    public ResultWrapper<Integer> create(T entity) {
        return ResultWrapper.success(service.create(entity));
    }

    @Override
    public ResultWrapper<Integer> createBatch(List<T> list) {
        return ResultWrapper.success(service.createBatch(list));
    }

    @Override
    public ResultWrapper<Integer> updateAll(T entity) {
        return ResultWrapper.success(service.updateAll(entity));
    }

    @Override
    public ResultWrapper<Integer> updateNotNull(T entity) {
        return ResultWrapper.success(service.updateNotNull(entity));
    }

    @Override
    public ResultWrapper<Integer> delete(T entity) {
        return ResultWrapper.success(service.delete(entity));
    }

    @Override
    public ResultWrapper<Integer> deleteById(Object id) {
        return ResultWrapper.success(service.deleteById(id));
    }

    @Override
    public ResultWrapper<Integer> count(T entity) {
        return ResultWrapper.success(service.count(entity));
    }

    @Override
    public ResultWrapper<String> sayHello(String name) {
        return ResultWrapper.success("Hello " + name);
    }
}
