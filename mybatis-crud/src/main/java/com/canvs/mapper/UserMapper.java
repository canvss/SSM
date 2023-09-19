package com.canvs.mapper;

import com.canvs.pojo.User;

import java.util.List;

public interface UserMapper {
    int insert(User user);
    int update(User user);
    int delete(User user);
    User selectById(int id);
    List<User> selectAll();
}
