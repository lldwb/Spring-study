package org.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ABCContextTest {

    @Test
    void context() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.getBean(ABCContext.class).context("a");
        context.getBean(ABCContext.class).context("b");
        context.getBean(ABCContext.class).context("c");
    }
}