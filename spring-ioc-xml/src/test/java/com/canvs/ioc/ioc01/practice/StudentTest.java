package com.canvs.ioc.ioc01.practice;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-ioc-xml-practice.xml");
        StudentController studentController = applicationContext.getBean(StudentController.class);
        studentController.getAll();
    }
}
