package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ConnectionPoolTest {

    @Test
    void getConnection() throws SQLException {
//        ConnectionPool connectionPool = new ConnectionPool(1);
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConnectionPool connectionPool = context.getBean(ConnectionPool.class);
        log.info("Pool size: " + connectionPool.size());
        Connection conn = connectionPool.getConnection();
        log.info("Pool size: " + connectionPool.size());
        conn.close();
        log.info("Pool size: " + connectionPool.size());
        conn = connectionPool.getConnection();
        log.info("Pool size: " + connectionPool.size());
        conn.close();
        log.info("Pool size: " + connectionPool.size());
//        conn = connectionPool.getConnection();
    }
}