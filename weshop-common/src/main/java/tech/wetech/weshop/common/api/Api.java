package tech.wetech.weshop.common.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tech.wetech.weshop.common.utils.Criteria;
import tech.wetech.weshop.common.utils.ResultWrapper;

import java.util.List;

public interface Api<T> {

    @GetMapping("/queryAll")
    ResultWrapper<List<T>> queryAll();

    @PostMapping(value = "/queryList")
    ResultWrapper<List<T>> queryList(@RequestBody T entity);

    @PostMapping("/queryByCriteria")
    ResultWrapper<List<T>> queryByCriteria(@RequestBody Criteria<T, Object> criteria);

    @PostMapping("/queryOneByCriteria")
    ResultWrapper<T> queryOneByCriteria(@RequestBody Criteria<T, Object> criteria);

    @PostMapping("/countByCriteria")
    ResultWrapper<Integer> countByCriteria(@RequestBody Criteria<T, Object> criteria);

    @PostMapping("/queryOne")
    ResultWrapper<T> queryOne(@RequestBody T entity);

    @GetMapping("/queryById")
    ResultWrapper<T> queryById(@RequestParam("id") Object id);

    @PostMapping("/create")
    ResultWrapper<Integer> create(@RequestBody T entity);

    @PostMapping("/createBatch")
    ResultWrapper<Integer> createBatch(@RequestBody List<T> list);

    @PostMapping("/updateAll")
    ResultWrapper<Integer> updateAll(@RequestBody T entity);

    @PostMapping("/updateNotNull")
    ResultWrapper<Integer> updateNotNull(@RequestBody T entity);

    @PostMapping("/delete")
    ResultWrapper<Integer> delete(@RequestBody T entity);

    @PostMapping("/deleteById")
    ResultWrapper<Integer> deleteById(@RequestBody Object id);

    @PostMapping("/count")
    ResultWrapper<Integer> count(@RequestBody T entity);

    @GetMapping("/sayHello")
    ResultWrapper<String> sayHello(@RequestParam("name") String name);

}
