package com.ytu.springcloud.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  //相当于ApplicationContext.xml 配置bean
public class ConfigBean {

    //配置负载均衡实现RestTemplate
    @LoadBalanced //Ribbon
    @Bean
    public RestTemplate getTemplate(){
        return new RestTemplate();
    }


}
