package com.canvs.aop;


import com.canvs.aop.aop04.Calculator;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:Spring-aop.xml")
public class CalculatorImplTest4 {
    @Resource
    private Calculator calculator;
    @Test
    public void test() {
        System.out.println(calculator.add(1, 2));
        calculator.div(3,0);
    }
}
