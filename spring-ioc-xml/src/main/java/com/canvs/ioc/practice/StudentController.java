package com.canvs.ioc.practice;

import java.util.List;

public class StudentController {
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void getAll() {
        List<Student> all = studentService.getAll();
        System.out.println("表述层：" + all);
    }
}
