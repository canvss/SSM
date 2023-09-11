package com.canvs.aop;


import com.canvs.aop.aop02.Calculator;
import com.canvs.aop.aop02.config.CalculatorConfig;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = {CalculatorConfig.class})
public class CalculatorImplTest2 {
    @Resource
    private Calculator calculator;
    @Test
    public void test() {
        System.out.println(calculator.add(1, 2));
        calculator.div(3,0);
    }
}
