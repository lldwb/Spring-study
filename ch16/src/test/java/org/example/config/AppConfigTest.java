package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

@Slf4j
class AppConfigTest {

    @Test
    void connection() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        log.debug("" + context.getBean(Connection.class));
        log.debug("" + context.getBean(Connection.class));
    }
}