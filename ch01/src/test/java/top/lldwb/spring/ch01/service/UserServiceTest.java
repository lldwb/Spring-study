package top.lldwb.spring.ch01.service;

import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {


    @Test
    void setUserList() {
        /* 创建容器工厂
         * 在spring框架中存在多种不同的容器工厂
         * 每个容器工厂都有自身的特点和功能，
         * 例如：当我们需要通过解析 xml 配置文件来初始化一个容器工厂时，可以使用 ClassPathXmlApplicationContext
         * 这个容器工厂，而这些工厂最终实现的都是 ApplicationContext
         * */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 从容器中根据 Bean 的 id 获取 Bean 的实例
        ((UserService)context.getBean("userService")).setUserList();
        // 使用泛型的方式不需要强制转换
        context.getBean("userService",UserService.class).setUserList();
        // 如果接口的实现类只有一个，可以不需要指定id，只需要泛型类型即可
        context.getBean(UserService.class).setUserList();
    }
}