package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.service.ABC;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class A implements ABC {
    @Override
    public void abc() {
        log.debug("执行"+this.getClass().getName());
    }
}
