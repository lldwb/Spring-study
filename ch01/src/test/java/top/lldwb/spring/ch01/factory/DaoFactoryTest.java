package top.lldwb.spring.ch01.factory;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.lldwb.spring.ch01.dao.UserDao;

import static org.junit.jupiter.api.Assertions.*;

class DaoFactoryTest {

    @Test
    void getUserDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        context.getBean("userDao", UserDao.class).setUserList();
        context.getBean("userDaoS", UserDao.class).setUserList();
    }
}