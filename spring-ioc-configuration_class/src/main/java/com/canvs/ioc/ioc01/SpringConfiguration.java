package com.canvs.ioc.ioc01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration  //标注当前类是配置类
@PropertySource("classpath:jdbc.properties")    //使用注解读取外部配置，替代<context:property-placeholder>
@ComponentScan(basePackages = "com.canvs.ioc.ioc01")    //可以配置扫描包，替代<context:component-scan>
public class SpringConfiguration {
}
