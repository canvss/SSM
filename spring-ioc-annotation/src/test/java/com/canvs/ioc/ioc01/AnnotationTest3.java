package com.canvs.ioc.ioc01;

import com.canvs.ioc.ioc01.ioc04.CommonComponent;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest3 {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-ioc-annotation-04.xml");
        CommonComponent commonComponent = applicationContext.getBean(CommonComponent.class);
        System.out.println(commonComponent);  //CommonComponent{name='canvs', city='上海'}
    }
}
