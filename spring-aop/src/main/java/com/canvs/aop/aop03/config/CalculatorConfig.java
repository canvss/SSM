package com.canvs.aop.aop03.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="com.canvs.aop.aop02")
@EnableAspectJAutoProxy //等于<aop:aspectj-autoproxy/> 开启Aspectj注解支持
public class CalculatorConfig {

}
