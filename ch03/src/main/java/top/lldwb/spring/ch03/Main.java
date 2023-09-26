package top.lldwb.spring.ch03;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.lldwb.spring.ch03.service.UserService;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.getBean("service1", UserService.class).save();
        context.getBean("service2", UserService.class).save();
        context.getBean("service3", UserService.class).save();
    }
}