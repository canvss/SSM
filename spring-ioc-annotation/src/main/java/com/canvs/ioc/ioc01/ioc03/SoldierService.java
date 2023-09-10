package com.canvs.ioc.ioc01.ioc03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoldierService {
    @Autowired
    private SoldierDAO soldierDAO;

    public void show(){
        System.out.println("soldierService ... ");
    }
}
