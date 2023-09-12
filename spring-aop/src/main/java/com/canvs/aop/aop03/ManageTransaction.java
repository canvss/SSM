package com.canvs.aop.aop03;


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class ManageTransaction {
    //通过在通知方法行参位置声明ProceedingJoinPoint类型的形参。Spring会将这个类型的对象传给我们
    public Object manageTransaction(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try{
            System.out.println("开启事务"); //before
            result = joinPoint.proceed(args);
            System.out.println("提交");   //AfterReturning
        }catch (Throwable e){
            System.out.println("事务回滚"); //AfterThrowing
            throw  new RuntimeException(e);
        }finally {
            System.out.println("结束。。。");    //After
        }
        return result;
    }
}
