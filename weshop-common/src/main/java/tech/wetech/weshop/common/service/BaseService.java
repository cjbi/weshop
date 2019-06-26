package tech.wetech.weshop.common.service;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tech.wetech.weshop.common.query.PageQuery;
import tech.wetech.weshop.common.query.QueryWrapper;
import tech.wetech.weshop.common.utils.MyMapper;
import tk.mybatis.mapper.code.Style;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @param <T>
 * @author cjbi@outlook.com
 */
public abstract class BaseService<T> implements IService<T> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

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
    public List<T> queryListByPage(T entity, PageQuery pageQuery) {
        if (pageQuery.getOrderBy() != null) {
            pageQuery.setOrderBy(StringUtil.convertByStyle(pageQuery.getOrderBy(), Style.camelhump));
        }
        return PageHelper.startPage(pageQuery)
                .doSelectPage(() -> mapper.select(entity));
    }

    @Override
    public List<T> queryListByQueryWrapper(QueryWrapper queryWrapper) {
        //分页查询
        if (queryWrapper.getPageQuery() != null) {
            PageHelper.startPage(queryWrapper.getPageQuery());
        }
        if (queryWrapper.getCondition() != null) {
            //Example查询
            if (queryWrapper.getCondition() instanceof Example) {
                return mapper.selectByExample(queryWrapper.getCondition());
            }
            //实体类查询
            Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            if (queryWrapper.getCondition().getClass().equals(tClass)) {
                return mapper.select((T) queryWrapper.getCondition());
            }
        }
        return mapper.selectAll();
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
