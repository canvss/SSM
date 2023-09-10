package com.canvs.ioc.ioc01;

import com.canvs.ioc.ioc01.ioc01.*;
import com.canvs.ioc.ioc01.ioc02.BeanOne;
import com.canvs.ioc.ioc01.ioc02.BeanTwo;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-ioc-annotation-01.xml");
        CommonComponent commonComponent = applicationContext.getBean(CommonComponent.class);
        commonComponent.show(); //CommonComponent ...
        UserController userController = applicationContext.getBean(UserController.class);
        userController.show();  //UserController ...
        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
        userService.show(); //UserServiceImpl ...
        UserDAOImpl userDAO = applicationContext.getBean(UserDAOImpl.class);
        userDAO.show(); //UserDAOImpl ...
        StudentController student = applicationContext.getBean("student", StudentController.class);
        System.out.println(student);
    }

    @Test
    public void test02() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-ioc-annotation-02.xml");
        BeanOne beanOne = applicationContext.getBean("beanOne", BeanOne.class);
        applicationContext.close();
    }

    @Test
    public void test03() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-ioc-annotation-02.xml");
        BeanTwo beanTwo = applicationContext.getBean(BeanTwo.class);
        BeanTwo beanTwo1 = applicationContext.getBean(BeanTwo.class);
        System.out.println(beanTwo1 == beanTwo); //false
    }

}
