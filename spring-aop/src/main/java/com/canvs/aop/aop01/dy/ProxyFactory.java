package com.canvs.aop.aop01.dy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }
    public Object getProxy(){
        //加载动态生成的代理类的类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //目标对象实现的所有接口的class对象所组成的数组
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object result = null;
                try {
                    System.out.println("[动态代理][日志] "+method.getName()+"，参数："+ Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("[动态代理][日志] "+method.getName()+"，结果："+ result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[动态代理][日志] "+method.getName()+"，异常："+e.getMessage());
                } finally {
                    System.out.println("[动态代理][日志] "+method.getName()+"，方法执行完毕");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }
}
