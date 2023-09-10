package com.canvs.ioc.ioc03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public UserServiceImpl userService(){
        return new UserServiceImpl();
    }
    @Bean
    public UserController userController(){
        UserController userController = new UserController();
        userController.setUserService(userService());
        return userController;
    }
}
