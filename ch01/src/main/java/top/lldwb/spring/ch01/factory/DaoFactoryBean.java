package top.lldwb.spring.ch01.factory;

import org.springframework.beans.factory.FactoryBean;
import top.lldwb.spring.ch01.dao.UserDao;
import top.lldwb.spring.ch01.dao.impl.UserDaoImplS;

/**
 * 自定义工厂，交给Spring创建
 */
public class DaoFactoryBean implements FactoryBean<UserDao> {
    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImplS();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDaoImplS.class;
    }
}
