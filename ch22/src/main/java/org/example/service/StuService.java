package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.holder.ApplicationContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StuService {
    private UserService userService;

    public void add() {
        userService = ApplicationContextHolder.getBean(UserService.class);
        userService.add();
    }
}