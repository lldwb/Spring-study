package top.lldwb.spring.ch01.dao.impl;

import lombok.extern.slf4j.Slf4j;
import top.lldwb.spring.ch01.dao.UserDao;

@Slf4j
public class UserDaoImplS implements UserDao {
    @Override
    public void setUserList() {
      log.info("成功");
    }
}
