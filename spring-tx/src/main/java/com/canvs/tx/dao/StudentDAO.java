package com.canvs.tx.dao;

import com.canvs.tx.pojo.Student;

public interface StudentDAO {
    void updateNameById(String name,int id);
    void updateAgeById(int age,int id);
    Student getStudentById(int id);
}
