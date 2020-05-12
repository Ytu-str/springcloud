package com.ytu.springcould.Controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ytu.springcloud.POJO.Dept;
import com.ytu.springcould.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeptController {
    @Autowired
    DeptService deptService;


    @HystrixCommand(fallbackMethod = "hystrixAddDept")
    @GetMapping("dept/get/{id}")
    public Dept addDept(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept==null){
            throw new RuntimeException("id=>"+id+"，不存在改用户");
        }
        return dept;
    }
    //备选方案


    public Dept hystrixAddDept(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("id=>"+id+"没有对应的信息");
    }


}
