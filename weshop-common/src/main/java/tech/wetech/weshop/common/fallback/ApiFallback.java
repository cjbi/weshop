package tech.wetech.weshop.common.fallback;

import tech.wetech.weshop.common.api.Api;
import tech.wetech.weshop.common.enums.CommonResultStatus;
import tech.wetech.weshop.common.utils.Criteria;
import tech.wetech.weshop.common.utils.ResultWrapper;

import java.util.List;

public abstract class ApiFallback<T> implements Api<T> {

    @Override
    public ResultWrapper<List<T>> queryAll() {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<List<T>> queryList(T entity) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<List<T>> queryByCriteria(Criteria<T, Object> criteria) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<T> queryOneByCriteria(Criteria<T, Object> criteria) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<Integer> countByCriteria(Criteria<T, Object> criteria) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<T> queryOne(T entity) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<T> queryById(Object id) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<Integer> create(T entity) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<Integer> createBatch(List<T> list) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<Integer> updateAll(T entity) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<Integer> updateNotNull(T entity) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<Integer> delete(T entity) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<Integer> deleteById(Object id) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<Integer> count(T entity) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }

    @Override
    public ResultWrapper<String> sayHello(String name) {
        return ResultWrapper.failure(CommonResultStatus.REMOTE_SERVICE_ERROR);
    }
}
