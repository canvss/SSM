package com.canvs.ioc.practice;

import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDAOImpl implements StudentDAO {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getAll() {
        String sql = "SELECT id,name,gender,age,class AS classes FROM students";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return studentList;
    }
}
