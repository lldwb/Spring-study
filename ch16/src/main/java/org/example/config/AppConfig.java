package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 将 properties 文件的属性注入到配置类的字段中
 * 由于 properties 文件时放在 resources目录 下，因此需要从
 * classpath 路径种查找资源
 */
@Slf4j
@Configuration
@PropertySource("jdbc.properties")
public class AppConfig {
    /**
     * 使用 @Value 注解结合 spel 表达式进行值注入，也就是将 properties 文件中的属性值注入到当前字段中
     */
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public Connection connection() {
        log.debug(driver);
        log.debug(url);
        log.debug(userName);
        log.debug(password);
        try {
            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
