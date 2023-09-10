package com.canvs.ioc.ioc01.ioc03;

public class BeanOne {
    public void init(){
        System.out.println("正在初始化BeanOne");
    }
    public void destroy(){
        System.out.println("BeanOne正在销毁");
    }
}
