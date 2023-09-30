package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    /**
     * 可以通过构造方法来注入
     * @param userDao
     */
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 这个set方法是专门用于提供给容器注入Bean
     *
     * @param userDao
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserDao dao = context.getBean(UserDao.class);
        dao.add();
    }
}
