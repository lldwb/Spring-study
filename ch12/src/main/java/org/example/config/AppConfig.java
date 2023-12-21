package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.example.controller.UserController;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.springframework.context.annotation.*;

/**
 * Spring 提倡使用注解和配置类来完成 Bean 的装配
 * 而配置类就是全面取代 xml配置文件 的一种方式
 *
 * @Configuration 注解用于标识一个类为合法的 Spring 配置类，默认 proxyBeanMethods(启动代理) 为 true
 * @ComponentScan 注解用于扫描指定的包，装配相关的 Bean
 * 对应 xml 中的扫描
 */
/**
 * 不加 @Configuration 就是 Lite，加 @Configuration 就是 Full
 * Lite[非代理](简单、迷你)：性能最高，不使用代理
 * Full[代理](全面)：使用代理
 *
 * Full底层(猜测)：对配置类进行动态代理，对所有方法增强(判断是否有@Bean注解，选择执行)
 *
 * 代理的作用：使用者不直接于被使用者联系，而是通过代理去联系，同时代理可以进行一些额外的操作(比如：返回存储的对象而不执行new对象)
 *
 * 所有 new 出来的对象都在堆中
 *
 * @Import 的三种用法：
 * 1. 导入普通的 Bean(不推荐)
 * 比如：@Import({UserController.class, UserServiceImpl.class})
 *
 * 2. 导入其他配置类(推荐)
 * 在项目中模块化配置类，包括 mvc 的配置类、mybatis 配置类、Redis 配置类、RabbitMQ 配置类等等
 * 那么可以在一个总配置类中导入其他这些配置类进行合并，
 * 这样维护性扩展性更强
 * 比如：@Import({MvcConfig.class,MybatisConfig.class})
 *
 * 3. 选择性导入(即按照指定的逻辑来导入相关的)(推荐)
 * 这种方式需要自定义一个导入选择器交给 spring 执行
 *
 */
@Slf4j
@Configuration
//@ComponentScan(basePackages = "org.example")
@Import({UserController.class, UserServiceImpl.class})
public class AppConfig {
//    /**
//     * 除了使用 @Component、@Service、@Controller
//     * @Respository 注解来装配 Bean 以外，还可以使用 @Bean 注解 在
//     *
//     * @Scope 声明作用域
//     *
//     * @return
//     */
//    @Bean
//    public UserService userService(){
//        return new UserServiceImpl();
//    }
//
//    /**
//     * 注入其他 Bean
//     * 1、使用参数注入(Spring进行注入)
//     * 2、调用Bean方法注入
//     *
//     * @return
//     */
//    @Bean
////    public UserController userController(UserService userService){
////        return new UserController(userService);
////    }
//    public UserController userController(){
//        log.debug("" + userService());
//        log.debug("" + userService());
//        log.debug("" + userService());
//        return new UserController(userService());
//    }
}
