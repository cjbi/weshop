package tech.wetech.weshop.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface Api<T> {

    @GetMapping("/queryAll")
    List<T> queryAll();

    @GetMapping("/queryList")
    List<T> queryList(T entity);

    @GetMapping("/queryOne")
    T queryOne(T entity);

    @GetMapping("/queryById")
    T queryById(@RequestParam("id") Object id);

    @PostMapping("/create")
    int create(@RequestBody T entity);

    @PostMapping("/updateAll")
    int updateAll(@RequestBody T entity);

    @PostMapping("/updateNotNull")
    int updateNotNull(@RequestBody T entity);

    @PostMapping("/delete")
    int delete(@RequestBody T entity);

    @PostMapping("/deleteById")
    int deleteById(@RequestBody Object id);

    @GetMapping("/count")
    int count(T entity);

}
