package com.canvs.ioc;

import com.canvs.ioc.ioc01.SpringConfiguration;
import com.canvs.ioc.ioc01.UserController;
import com.canvs.ioc.ioc03.AppConfig;
import com.canvs.ioc.ioc03.BeanOne;
import com.canvs.ioc.ioc03.ScopeConfig;
import com.canvs.ioc.ioc03.UserConfig;
import com.canvs.ioc.ioc04.ConfigB;
import com.canvs.ioc.ioc04.Person;
import com.canvs.ioc.ioc04.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationClassTest {
    @Test
    public void test() {
        // AnnotationConfigApplicationContext-IOC容器对象
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserController userController = configApplicationContext.getBean(UserController.class);
        userController.show();
    }


    @Test
    public void test2() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(SpringConfiguration.class);   //外部设置配置类
        configApplicationContext.refresh(); //刷新后方可生效
        UserController userController = configApplicationContext.getBean(UserController.class);
        userController.show();
    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        BeanOne beanOne = configApplicationContext.getBean(BeanOne.class);
        configApplicationContext.close();
    }
    @Test
    public void test04(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
        BeanOne beanOne = configApplicationContext.getBean("beanOne", BeanOne.class);
        BeanOne beanOne2 = configApplicationContext.getBean("beanOne", BeanOne.class);
        System.out.println(beanOne2 == beanOne);    //false
        BeanOne beanOne3 = configApplicationContext.getBean("beanOne1", BeanOne.class);
        BeanOne beanOne4 = configApplicationContext.getBean("beanOne1", BeanOne.class);
        System.out.println(beanOne3 == beanOne4); //true
    }
    @Test
    public void test05(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
        com.canvs.ioc.ioc03.UserController userController = configApplicationContext.getBean(com.canvs.ioc.ioc03.UserController.class);
        System.out.println(userController);
    }
    @Test
    public void test06(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigB.class);
        Person person = context.getBean(Person.class);
        Student student = context.getBean(Student.class);
        System.out.println(person);
        System.out.println(student);
    }
}
