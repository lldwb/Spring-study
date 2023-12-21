package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.example.User;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 将 properties 文件的属性注入到配置类的字段中
 * 由于 properties 文件时放在 resources目录 下，因此需要从
 * classpath 路径种查找资源
 */
@Slf4j
@Configuration
@ComponentScan("org.example")
// 启动 AspectJ 注解处理器
// 强制启动 CGLIB 生成代理
@EnableAspectJAutoProxy(proxyTargetClass = true)


public class AppConfig {

    /**
     * 代理工厂负责创建代理对象
     * 装配代理，让 spring 在运行时动态创建一个代理对象
     * 代理对象是通过 ProxyFactoryBean 这个代理工厂创建出来的
     * 并且这个代理对象也会自动纳入纳入容中管理
     *
     * proxyInterfaces 属性
     * 用于注入接口信息，如果有接口，就执行 JDK 代理
     *
     * target 属性
     * 用于注入目标对象，这样spring才知道要为创建代理，
     * 目标对象可以直接使用 目标对象的id
     *
     * interceptorNames 属性
     * 配置切面，可以配置多个切面
     * @return
     */
//    @Bean
//    public User userProxy() throws ClassNotFoundException {
//        ProxyFactoryBean factoryBean = new ProxyFactoryBean();
////        factoryBean.setProxyInterfaces(User.class.getInterfaces());
//        factoryBean.setTarget(new User());
//        factoryBean.setInterceptorNames("org.example.aop.UserAspect");
//        return (User) factoryBean.getObject();
//    }
}
