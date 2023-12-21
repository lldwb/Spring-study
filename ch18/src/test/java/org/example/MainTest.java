package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.config.AppConfig;
import org.example.invocation.AgencyHandler;
import org.example.invocation.AgencyUtil;
import org.example.invocation.ext.AgencyHandlerExt;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
class MainTest {

    @Test
    void main() throws ClassNotFoundException {
//        log.info(""+User.class.getInterfaces().toString());
//        log.info(""+User.class.getInterfaces().length);

//        User user = new User();
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(user.getClass());
//        User finalUser = user;
//        enhancer.setCallback((MethodInterceptor) (obj, method, objects, methodProxy) -> {
//            log.info("ntr");
//            return method.invoke(finalUser,objects);
//        });
//        user = (User) enhancer.create();
//        user.user();

//        User user = AgencyUtil.getObject(new User(),new AgencyHandlerExt());
//        user.user();
//
//        UserService userService = AgencyUtil.getObject(new UserServiceImpl(),new AgencyHandlerExt());
//        userService.add();
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.getBean("userProxy", User.class).user();
    }
}