package top.lldwb.spring.ch04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.lldwb.spring.ch04.service.UserService;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.getBean("userService", UserService.class);
        // 关闭容器，这是容器会销毁所有的 Bean，在销毁前先执行相关的 destroy 方法
        // 销毁方法只管单例，因为原型创建的对象是一次性的， Spring 只保存 class 对象(不是实例/Bean对象)，所以只管创建不管销毁
        // 重点 spring 管理 bean 的生命周期是针对单例的 bean
        // 通过原型创建的 bean 不会纳入 spring 容器中，因此不会执行生命周期的方法
        ((ClassPathXmlApplicationContext)context).close();
        log.info("24");
    }
}