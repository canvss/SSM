package com.canvs.test;

import com.canvs.mapper.UserMapper;
import com.canvs.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    private SqlSession session;

    @BeforeEach
    public void start() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sessionFactory.openSession();
    }

    @AfterEach
    public void over() {
        session.commit();
        session.close();
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("canvs");
        user.setPassword("123456");
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int id = userMapper.insert(user);
        System.out.println(id);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1);
        user.setUsername("canvs");
        user.setPassword("canvs");
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int row = userMapper.update(user);
        System.out.println(row);
    }

    @Test
    public void delete() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        int row = userMapper.delete(user);
        System.out.println(row);
    }

    @Test
    public void selectById() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectById(3);
        System.out.println(user);
    }

    @Test
    public void selectAll() {
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        users.forEach(System.out::println);
    }
}
