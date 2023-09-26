package org.example.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.UserDao;

@Slf4j
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        log.debug("234");
    }
}
