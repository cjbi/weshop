package tech.wetech.weshop.fallback;

import tech.wetech.weshop.api.Api;
import tech.wetech.weshop.utils.Result;

import java.util.List;

public abstract class ApiFallback<T> implements Api<T> {

    @Override
    public Result<List<T>> queryAll() {
        return null;
    }

    @Override
    public Result<List<T>> queryList(T entity) {
        return null;
    }

    @Override
    public Result<T> queryOne(T entity) {
        return null;
    }

    @Override
    public Result<T> queryById(Object id) {
        return null;
    }

    @Override
    public Result<Integer> create(T entity) {
        return null;
    }

    @Override
    public Result<Integer> updateAll(T entity) {
        return null;
    }

    @Override
    public Result<Integer> updateNotNull(T entity) {
        return null;
    }

    @Override
    public Result<Integer> delete(T entity) {
        return null;
    }

    @Override
    public Result<Integer> deleteById(Object id) {
        return null;
    }

    @Override
    public Result<Integer> count(T entity) {
        return null;
    }

    @Override
    public Result<String> sayHello(String name) {
        return null;
    }
}
