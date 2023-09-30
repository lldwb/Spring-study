package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoFImpl;
import org.example.dao.impl.UserDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class UserControllerTest {

    @Test
    void add() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        UserController controller = context.getBean(UserController.class);
//        controller.add();
        log.debug(""+UserDao.class.isAssignableFrom(UserDaoFImpl.class.getClass()));
        log.debug(""+UserDaoFImpl.class.isAssignableFrom(UserDao.class.getClass()));
        log.debug(""+UserDaoFImpl.class.isAssignableFrom(UserDaoImpl.class.getClass()));
        log.debug(""+UserDaoFImpl.class.isAssignableFrom(UserDaoFImpl.class.getClass()));

        log.debug(""+UserDao.class.isInstance(new UserDaoFImpl()));
        log.debug(""+UserDaoFImpl.class.isInstance(new UserDaoFImpl()));
        log.debug(""+UserDaoFImpl.class.isInstance(new UserDaoImpl()));
    }
}