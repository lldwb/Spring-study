package org.example;

import org.example.config.AppConfig;
import org.example.my.MyEvent;
import org.example.service.StuService;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(UserService.class).add();
        context.getBean(StuService.class).add();

        MyEvent event = new MyEvent("1234567");
        context.publishEvent(event);

        while (true);
    }
}