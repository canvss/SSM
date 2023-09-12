package com.canvs.aop.aop03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect //表示这个类是一个切面类
@Component
public class LogAspect {
    @Pointcut(value = "execution(public int com.canvs.aop.aop03.impl.CalculatorImpl.*(int,int))")
    public void declarPointCut(){}
    @Before(value = "declarPointCut()")
    public void printLogBeforeCore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        String signatureName = signature.getName();
        System.out.println("method = " + signatureName);
        int modifiers = signature.getModifiers();
        System.out.println("modifiers = " + modifiers);
        String declaringTypeName = signature.getDeclaringTypeName();
        System.out.println("declaringTypeName = " + declaringTypeName);
        Object[] args = joinPoint.getArgs();
        System.out.println("args = " + Arrays.toString(args));
        System.out.println("[AOP前置通知] " + signatureName + "开始了");

    }

    @AfterReturning(value = "com.canvs.aop.aop03.LogAspect.declarPointCut()",returning = "tar")
    public void printLogAfterSuccess(JoinPoint joinPoint,Object tar) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[AOP返回通知] "+methodName+" 方法成功返回了,返回值是 "+tar);

    }

    @AfterThrowing(value = "declarPointCut()" ,throwing = "t")
    public void printLogAfterException(JoinPoint joinPoint,Throwable t) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("[AOP异常通知] "+methodName+"方法抛异常了，异常类型是：" + t.getClass().getName());
    }

    @After(value = "declarPointCut()")
    public void printLogFinallyEnd() {
        System.out.println("[AOP后置通知] 方法最终结束了");
    }

}
