package com.canvs.ioc.ioc03;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.canvs.ioc.ioc03")
public class AppConfig {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public BeanOne beanOne(){
        return new BeanOne();
    }
}
