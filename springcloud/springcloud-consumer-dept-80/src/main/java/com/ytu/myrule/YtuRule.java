package com.ytu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YtuRule {
    @Bean
    public IRule myRile(){
        return new RoundRobinRule();
    }
}
