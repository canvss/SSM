package com.canvs.ioc.ioc04;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConfigA.class)
@ComponentScan(basePackages = "com.canvs.ioc.ioc04")
public class ConfigB {
    @Bean
    public Student student(){
        return new Student();
    }
}
