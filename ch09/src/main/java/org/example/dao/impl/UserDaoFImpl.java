package org.example.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.UserDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @Component注解用于标识当前类为一个Bean 这样就会被 spring 容器扫描到，可以通过 value 属性来指定 Bean 的 id
 * 如果不指定 value ，默认的 id 就是当前类名并将首字母改成小写(例如：userDaoImpl)
 */
//@Component("userDao")
//@Repository 持久层(dao)专属注解，取代 @Component
@Repository("userDaoFImpl")

@Slf4j
public class UserDaoFImpl implements UserDao {
    @Override
    public void add() {
        log.debug("UserDaoFImpl");
    }
}
