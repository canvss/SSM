package com.canvs.tx.service;

import com.canvs.tx.dao.StudentDAO;
import com.canvs.tx.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
@Transactional(readOnly = true)
public class StudentSerivce {
    @Autowired
    private StudentDAO studentDAO;
    //timeout设置事务超时时长，单位秒，默认-1永不超时
    @Transactional(readOnly = false,timeout = 3)  //使用声明式注解
    public void changeInfo() throws InterruptedException {
        studentDAO.updateNameById("tom",3);
        Thread.sleep(4000); //休眠4s等待方法超时抛TransactionTimedOutException异常
        studentDAO.updateAgeById(30,3);
        System.out.println("over!");
    }

    //@Transactional(readOnly = true) //默认为false
    public void showStudentById(){
        Student student = studentDAO.getStudentById(1);
        System.out.println(student);
    }
    //默认针对运行时异常回滚
    //isolation = 设置事务的隔离级别,mysql默认是repeatable read!
    @Transactional(readOnly = false,timeout = 3,rollbackFor = Exception.class,noRollbackFor = FileNotFoundException.class,isolation = Isolation.REPEATABLE_READ)  //使用声明式注解
    public void changeInfo1() throws InterruptedException, FileNotFoundException {
        studentDAO.updateNameById("tom",6);
        new FileInputStream("asfafa");   //不会回滚
        studentDAO.updateAgeById(30,6);
        System.out.println("over!");
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void changeAge(){
        studentDAO.updateAgeById(10,1);
    }
    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public void changeName(){
        int i = 3/0;
        studentDAO.updateNameById("canvs",1);
    }
}
