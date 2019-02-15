package tech.wetech.weshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import tech.wetech.weshop.service.IService;

import java.util.List;

public class BaseApi<T> implements Api<T> {

    @Autowired
    protected IService<T> service;

    @Override
    public List<T> queryAll() {
        return service.queryAll();
    }

    @Override
    public List<T> queryList(T entity) {
        return service.queryList(entity);
    }

    @Override
    public T queryOne(T entity) {
        return service.queryOne(entity);
    }

    @Override
    public T queryById(Object id) {
        return service.queryById(id);
    }

    @Override
    public int create(T entity) {
        return service.create(entity);
    }

    @Override
    public int updateAll(T entity) {
        return service.updateAll(entity);
    }

    @Override
    public int updateNotNull(T entity) {
        return service.updateNotNull(entity);
    }

    @Override
    public int delete(T entity) {
        return service.delete(entity);
    }

    @Override
    public int deleteById(Object id) {
        return service.deleteById(id);
    }

    @Override
    public int count(T entity) {
        return service.count(entity);
    }
}
