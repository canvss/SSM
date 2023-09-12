package com.canvs.aop.aop03;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointCut {
    @Pointcut(value = "execution(public int com.canvs.aop..*.*(..))")
    public void globalPointCut(){}
    @Pointcut(value = "execution(* *.*.*.*(..,int))")
    public void secondPointCut(){}
    @Pointcut(value = "execution(private void com.canvs..*.*Impl.*(..))")
    public void transactionPointCut(){}
}
