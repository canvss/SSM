package com.canvs.ioc.ioc01;

import com.canvs.ioc.ioc01.ioc03.SoldierController;
import com.canvs.ioc.ioc01.ioc03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest2 {
    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-ioc-annotation-03.xml");
        SoldierController soldierController = applicationContext.getBean(SoldierController.class);
        soldierController.show();
        UserController user = applicationContext.getBean(UserController.class);
        user.show();
    }
}
