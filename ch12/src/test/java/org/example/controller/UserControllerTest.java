package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.config.AppConfig;
import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class UserControllerTest {

    @Test
    void add() {
        /**
         * 对原型的预期是每次从容器注入都是新的，而单例在容器中的只会有一个
         * 原型失效：当一个单例的 Bean 注入一个原型的 Bean，原型是会失效
         * 单例在创建时已经注入了一个原型，而每次都需要新的原型
         * 只需要在单例每次从容器中拿出时进行一次注入，而这个存在
         */
//        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        /**
         * 构造方法给 配置类.class 对象
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(UserController.class).add();
        context.getBean(UserController.class).add();
//        log.debug(""+context.getBean(UserService.class));
//        log.debug(""+context.getBean(UserService.class));
//        log.debug(""+context.getBean(UserService.class));
    }
}