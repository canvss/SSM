package com.canvs.ioc.ioc03;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SpringConfiguration {
    @Bean("user")   //指定名称
    public User user(){
        return new User();
    }
    @Bean
    public Book book(){
        return new Book();
    }
}
class User{}

class Book{}