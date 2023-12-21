package org.example.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Spring 提倡使用注解和配置类来完成 Bean 的装配
 * 而配置类就是全面取代 xml配置文件 的一种方式
 *
 * @Configuration 注解用于标识一个类为合法的 Spring 配置类
 * @ComponentScan 注解用于扫描指定的包，装配相关的 Bean
 * 对应 xml 中的扫描
 */
@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {
//    public ABCContext abcContext(){
//        return new ABCContext();
//    }
}
