package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.UserDao;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("userService")
//@Service 业务层专属注解，取代 @Component
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
//    @Qualifier("userDaoFImpl")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //    /**
//     * 可以通过构造方法来注入
//     * @param userDao
//     */
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void add() {
        log.debug("UserServiceImpl");
        userDao.add();
    }
}
