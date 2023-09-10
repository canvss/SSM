package com.canvs.ioc.ioc03;

public class UserController {
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    private UserServiceImpl userService;
}
