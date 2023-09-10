package com.canvs.ioc.ioc01.practice;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    @Resource
    private StudentService studentService;

    public void getAll() {
        List<Student> all = studentService.getAll();
        System.out.println("表述层：" + all);
    }
}
