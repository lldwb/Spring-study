package org.example;

import org.example.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserController controller = context.getBean(UserController.class);
//        UserController controller = new UserController();
        controller.add();
    }
}