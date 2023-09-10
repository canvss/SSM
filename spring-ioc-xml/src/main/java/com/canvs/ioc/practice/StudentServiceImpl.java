package com.canvs.ioc.practice;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentDAO studentDAO;
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
    @Override
    public List<Student> getAll() {
        return studentDAO.getAll();
    }
}
