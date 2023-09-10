package com.canvs.ioc.ioc01.ioc02;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ConfigurableObjectInputStream;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)   //多例
// @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON) //单列
public class BeanTwo {
    @PostConstruct
    public void init(){
        System.out.println("init ...");
    }
}
