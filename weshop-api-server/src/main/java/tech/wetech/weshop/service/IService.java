package tech.wetech.weshop.service;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通用接口
 *
 * @param <T>
 */
public interface IService<T> {

    List<T> queryAll();

    List<T> queryList(T entity);

    T queryOne(T entity);

    T queryById(Object id);

    PageInfo<T> queryPageInfo(T entity, int pageNum, int pageSize);

    int create(T entity);

    int updateAll(T entity);

    int updateNotNull(T entity);

    int delete(T entity);

    int deleteById(Object id);

    //TODO 其他...

}
