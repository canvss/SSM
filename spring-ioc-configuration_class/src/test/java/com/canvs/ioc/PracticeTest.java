package com.canvs.ioc;

import com.canvs.ioc.practice.PracticeConfig;
import com.canvs.ioc.practice.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PracticeConfig.class);
        StudentController studentController = context.getBean(StudentController.class);
        studentController.getAll();
    }
}
