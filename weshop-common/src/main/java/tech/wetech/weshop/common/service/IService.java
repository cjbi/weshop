package tech.wetech.weshop.common.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.common.query.PageQuery;

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

    T queryOne(T entity);

    T queryById(@RequestParam("id") Object id);

    List<T> queryPageList(T entity, PageQuery pageQuery);

    int create(@RequestBody T entity);

    int updateAll(@RequestBody T entity);

    int updateNotNull(@RequestBody T entity);

    int delete(@RequestBody T entity);

    int deleteById(@RequestBody Object id);

    int count(T entity);

}
