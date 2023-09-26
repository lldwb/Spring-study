package top.lldwb.spring.ch02.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class UserServiceTest {

    @Test
    void save() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.getBean(UserService.class).setString("1312");
        log.debug(context.getBean(UserService.class).getString());
        log.debug(String.valueOf(context.getBean(UserService.class) == new UserService()));
    }
}