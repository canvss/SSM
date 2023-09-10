package com.canvs.ioc.ioc04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.canvs.ioc.ioc04")
public class ConfigA {
    @Bean
    public Person person(){
        return new Person();
    }
}
