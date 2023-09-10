package com.canvs.ioc.ioc01;

import org.springframework.stereotype.Component;

@Component
public class CommonComponent {
    public void show(){
        System.out.println("CommonComponent ... ");
    }
}
