package com.canvs.ioc.ioc01;

import com.canvs.ioc.ioc01.practice.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class practiceTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-ioc-annotation-practice.xml");
        StudentController studentController = applicationContext.getBean(StudentController.class);
        studentController.getAll();
    }
}
