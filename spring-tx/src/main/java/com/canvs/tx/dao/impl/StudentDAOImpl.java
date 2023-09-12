package com.canvs.tx.dao.impl;

import com.canvs.tx.dao.StudentDAO;
import com.canvs.tx.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void updateNameById(String name, int id) {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql,name,id);
    }

    @Override
    public void updateAgeById(int age, int id) {
        String sql = "UPDATE students SET age = ? WHERE id = ?";
        jdbcTemplate.update(sql,age,id);
    }

    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT id,name,gender,age,class AS classes FROM students WHERE id = ?";
        List<Student> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class), id);
        return query.get(0) ;
    }
}
