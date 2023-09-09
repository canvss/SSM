package com.canvs.ioc;

import com.canvs.ioc.ioc01.ClientService;
import com.canvs.ioc.ioc01.HappyComponent;
import com.canvs.ioc.ioc02.SimpleMovieLister;
import com.canvs.ioc.ioc02.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCXmlTest2 {

    ApplicationContext context = new ClassPathXmlApplicationContext("Spring-ioc-xml-02.xml");
    @Test
    public void testUserService(){
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.userDao);
    }
    @Test
    public void testUserService2(){
        UserService userService1 = context.getBean("userService2", UserService.class);
        System.out.println(userService1);   //UserService{userDao=com.canvs.ioc.ioc02.UserDao@c333c60, id=1001, name='canvs'}
    }
    @Test
    public void testSimpleMovieLister(){
        SimpleMovieLister simpleMovieLister = context.getBean("simpleMovieLister", SimpleMovieLister.class);
        System.out.println(simpleMovieLister.getMovieName());
    }
    @Test
    public void getBeanFormIoC(){
        ApplicationContext context1 = new ClassPathXmlApplicationContext("Spring-ioc-xml-01.xml");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations("Spring-ioc-xml-01.xml");
        applicationContext.refresh();   //ioc di的动作
    }
}
