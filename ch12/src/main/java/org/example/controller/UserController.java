package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
//@Controller
/**
 * @Scope 设置 Bean 的作用域，对应 xml 中的 scope 实现
 * 当不知道 value 属性时，默认是单例(singleton)，如果要使用原型就需要 value 为 prototype
 */
//@Scope("prototype")
public class UserController {
    private final UserService userService;
    public void add(){
        userService.add();
    }
}
