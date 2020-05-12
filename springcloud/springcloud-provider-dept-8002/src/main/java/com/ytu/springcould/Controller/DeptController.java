package com.ytu.springcould.Controller;


import com.ytu.springcloud.POJO.Dept;
import com.ytu.springcould.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    DeptService deptService;
    @Autowired
    private DiscoveryClient client;

    @PostMapping("dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("dept/get/{id}")
    public Dept addDept(@PathVariable("id") Long id){
        return deptService.queryById(id);
    }
    @GetMapping("dept/list")
    public List<Dept> addDept(){
        return deptService.queryAll();
    }

    //注册进来的微服务，获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获得微服务列表的清单
        List<String> services = client.getServices();
        System.out.println(services);

        //得到一个具体的微服务信息
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+instance.getInstanceId()+instance.getPort());

        }
        return this.client;
    }
}
