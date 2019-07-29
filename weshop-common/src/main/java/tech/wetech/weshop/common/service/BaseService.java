package tech.wetech.weshop.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tech.wetech.weshop.common.utils.Criteria;
import tech.wetech.weshop.common.utils.MyMapper;

import java.util.List;

/**
 * @param <T>
 * @author cjbi@outlook.com
 */
public abstract class BaseService<T> implements IService<T> {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected MyMapper<T> mapper;


    @Override
    public List<T> queryAll() {
        return mapper.selectAll();
    }

    @Override
    public List<T> queryList(T entity) {
        return mapper.select(entity);
    }

    @Override
    public T queryOne(T entity) {
        return mapper.selectOne(entity);
    }

    @Override
    public T queryById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> queryByCriteria(Criteria<T, Object> criteria) {
        return mapper.selectBySql(criteria.buildSql());
    }

    @Override
    public T queryOneByCriteria(Criteria<T, Object> criteria) {
        List<T> ts = mapper.selectBySql(criteria.buildSql());
        if (ts.size() == 0) {
            return null;
        }
        return ts.get(0);
    }

    @Override
    public int countByCriteria(Criteria<T, Object> criteria) {
        return mapper.countBySql(criteria.buildCountSql());
    }

    @Override
    public int create(T entity) {
        return mapper.insertSelective(entity);
    }

    @Override
    public int createBatch(List<T> list) {
        return mapper.insertList(list);
    }

    @Override
    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int delete(T entity) {
        return mapper.delete(entity);
    }

    @Override
    public int deleteById(Object id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int count(T entity) {
        return mapper.selectCount(entity);
    }
}
