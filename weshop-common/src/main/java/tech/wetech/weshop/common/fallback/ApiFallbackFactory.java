package tech.wetech.weshop.common.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.enums.ResultStatus;
import tech.wetech.weshop.common.query.Criteria;
import tech.wetech.weshop.common.utils.Result;

import java.util.List;

@Component
public class ApiFallbackFactory<T> implements FallbackFactory<Api<T>> {

    @Override
    public Api<T> create(Throwable throwable) {
        return new Api<T>() {
            @Override
            public Result<List<T>> queryAll() {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<List<T>> queryList(T entity) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<List<T>> queryByCriteria(Criteria<T, Object> criteria) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<T> queryOneByCriteria(Criteria<T, Object> criteria) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<Integer> countByCriteria(Criteria<T, Object> criteria) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<T> queryOne(T entity) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<T> queryById(Object id) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<Integer> create(T entity) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<Integer> createBatch(List<T> list) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<Integer> updateAll(T entity) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<Integer> updateNotNull(T entity) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<Integer> delete(T entity) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<Integer> deleteById(Object id) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<Integer> count(T entity) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }

            @Override
            public Result<String> sayHello(String name) {
                return Result.failure(ResultStatus.REMOTE_SERVICE_ERROR);
            }
        };
    }


}
