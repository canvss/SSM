package com.cavns.tx;

import com.canvs.tx.config.SpringTXConfig;
import com.canvs.tx.controller.StudentController;
import com.canvs.tx.service.StudentSerivce;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

@SpringJUnitConfig(value = {SpringTXConfig.class})
public class SpringTXTest {
    @Autowired
    private StudentSerivce studentSerivce;
    @Autowired
    private StudentController studentController;

    @Test
    public void test() throws InterruptedException, FileNotFoundException {
        studentSerivce.changeInfo1();
        studentSerivce.showStudentById();
    }
    @Test
    public void test1(){
        studentController.change();
    }
}
