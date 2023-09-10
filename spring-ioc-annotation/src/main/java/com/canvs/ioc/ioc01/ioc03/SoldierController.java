package com.canvs.ioc.ioc01.ioc03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SoldierController {
    @Autowired
    private SoldierService soldierService;
    public void show(){
        soldierService.show();
    }

    public SoldierController() {
    }

    //    @Autowired
    public SoldierController(SoldierService soldierService){
        this.soldierService = soldierService;
    }

//    @Autowired
    public void setSoldierService(SoldierService soldierService) {
        this.soldierService = soldierService;
    }
}
