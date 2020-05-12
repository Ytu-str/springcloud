package com.ytu.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ytu.springcloud"})
public class FeginDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeginDeptConsumer_80.class,args);
    }
}
