package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component

//@Controller 控制层专属注解，取代 @Component
@Controller
@Slf4j
public class UserController {
//    @Autowired
    private UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void add(){
        log.debug("UserController");
        userService.add();
    }
}
