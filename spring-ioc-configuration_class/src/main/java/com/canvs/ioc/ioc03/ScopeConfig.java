package com.canvs.ioc.ioc03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeConfig {
    @Bean
    @Scope("prototype")
    public BeanOne beanOne(){
        return new BeanOne();
    }
    @Bean
    @Scope("singleton")
    public BeanOne beanOne1(){
        return new BeanOne();
    }
}
