package tech.wetech.weshop.common.service;

import tech.wetech.weshop.common.utils.Criteria;

import java.util.List;

/**
 * 通用接口
 *
 * @param <T>
 * @author cjbi@outlook.com
 */
public interface IService<T> {

    List<T> queryAll();

    List<T> queryList(T entity);

    List<T> queryByCriteria(Criteria<T, Object> criteria);

    T queryOneByCriteria(Criteria<T, Object> criteria);

    int countByCriteria(Criteria<T, Object> criteria);

    T queryOne(T entity);

    T queryById(Object id);

    int create(T entity);

    int createBatch(List<T> list);

    int updateAll(T entity);

    int updateNotNull(T entity);

    int delete(T entity);

    int deleteById(Object id);

    int count(T entity);

}
