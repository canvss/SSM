package com.canvs.ioc.ioc02;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanOne {
    @PostConstruct  //注解指定初始化方法
    public void init(){
        System.out.println("init ....");
    }
    @PreDestroy //注解指定销毁方法
    public void destroy(){
        System.out.println("destroy ....");
    }
}
