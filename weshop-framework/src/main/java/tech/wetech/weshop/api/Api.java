package tech.wetech.weshop.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface Api<T> {

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    List<T> queryAll();

    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    List<T> queryList(T entity);

    @RequestMapping(value = "/queryOne", method = RequestMethod.GET)
    T queryOne(T entity);

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
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

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    int count(T entity);

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    String sayHello(String name);

}
