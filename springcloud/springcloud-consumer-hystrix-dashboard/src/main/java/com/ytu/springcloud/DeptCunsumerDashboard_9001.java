package com.ytu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard//开启Dashboard
public class DeptCunsumerDashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptCunsumerDashboard_9001.class,args);
    }
}
