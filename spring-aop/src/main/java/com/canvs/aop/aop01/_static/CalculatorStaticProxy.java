package com.canvs.aop.aop01._static;

import com.canvs.aop.aop01.Calculator;

public class CalculatorStaticProxy implements Calculator {
    private Calculator calculator;
    private int result;
    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }
    @Override
    public int add(int i, int j) {
        System.out.println("参数是：" + i + "," + j);
        result = calculator.add(i, j);
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("参数是：" + i + "," + j);
        result = calculator.sub(i, j);
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("参数是：" + i + "," + j);
        result = calculator.mul(i, j);
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("参数是：" + i + "," + j);
        result = calculator.div(i, j);
        System.out.println("方法内部 result = " + result);
        return result;
    }
}
