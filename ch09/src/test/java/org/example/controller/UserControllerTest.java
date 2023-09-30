package org.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void add() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserController controller = context.getBean(UserController.class);
        controller.add();
    }
}