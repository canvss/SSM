package com.canvs.ioc.ioc01;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl {
    public void show(){
        System.out.println("UserDAOImpl ... ");
    }
}
