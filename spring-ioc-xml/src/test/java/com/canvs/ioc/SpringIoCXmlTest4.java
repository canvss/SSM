package com.canvs.ioc;

import com.canvs.ioc.ioc04.HappyFactoryBean;
import com.canvs.ioc.ioc04.HappyMachine;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCXmlTest4 {
    @Test
    public void testFactoryBean(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-ioc-xml-04.xml");
        //直接根据FactoryBean的id，获取的是getObject方法返回的对象
        HappyMachine happyMachine = applicationContext.getBean("happyMachine", HappyMachine.class);
        System.out.println(happyMachine.getMachineName());
        System.out.println(happyMachine);
        //如果想要获取FactoryBean对象，直接在id前添加&符号即可
        HappyFactoryBean bean = applicationContext.getBean("&happyMachine", HappyFactoryBean.class);
        System.out.println(bean);
    }
}
