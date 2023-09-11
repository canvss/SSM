package com.canvs.aop;

import com.canvs.aop.aop01.Calculator;
import com.canvs.aop.aop01.dy.ProxyFactory;
import com.canvs.aop.aop01.impl.CalculatorImpl;
import com.canvs.aop.aop01._static.CalculatorStaticProxy;
import org.junit.jupiter.api.Test;

public class CalculatorImplTest {
    @Test
    public void test(){
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(new CalculatorImpl());
        System.out.println(calculatorStaticProxy.add(1, 3));
    }
    @Test
    public void test02(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator calculator = (Calculator) proxyFactory.getProxy();
        calculator.add(2,3);
    }
}
