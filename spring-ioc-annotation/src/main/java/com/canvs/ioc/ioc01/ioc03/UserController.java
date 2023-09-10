package com.canvs.ioc.ioc01.ioc03;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    public void show(){
        System.out.println(userService);
    }
}

interface UserService{ }
@Service
class UserServiceImpl implements UserService{ }