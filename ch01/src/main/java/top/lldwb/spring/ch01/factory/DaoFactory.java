package top.lldwb.spring.ch01.factory;

import top.lldwb.spring.ch01.dao.UserDao;
import top.lldwb.spring.ch01.dao.impl.UserDaoImpl;

/**
 * 自定义工厂，交给Spring创建
 */
public class DaoFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
