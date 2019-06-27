package tech.wetech.weshop.common.utils;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * 继承自己的MyMapper
 *
 * @param <T>
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
    @Select("${sql}")
    List<T> selectBySql(@Param("sql") String sql);

    @Select("${sql}")
    Integer countBySql(@Param("sql") String countSql);
}
