package com.canvs.tx.controller;

import com.canvs.tx.service.StudentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class StudentController {
    @Autowired
    private StudentSerivce studentSerivce;
    @Transactional
    public void change(){
        studentSerivce.changeAge();
        studentSerivce.changeName();
    }
}
