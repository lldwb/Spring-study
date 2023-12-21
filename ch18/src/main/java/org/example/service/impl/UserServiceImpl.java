package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Slf4j
//@Service
@Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        log.debug("添加用户"+this);
        log.debug("添加用户"+this);
    }
}
