package com.canvs.ioc;

import com.canvs.ioc.practice.PracticeConfig;
import com.canvs.ioc.practice.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = {PracticeConfig.class})
public class Junit5IntegrationTest {
    @Autowired
    private StudentController studentController;
    @Test
    public void test(){
        studentController.getAll();
    }
}
