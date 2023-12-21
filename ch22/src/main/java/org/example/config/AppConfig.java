package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@ComponentScan("org.example")
// 启用定时任务注解处理器
@EnableScheduling
public class AppConfig implements SchedulingConfigurer {
    /**
     * 实现 SchedulingConfigurer 接口，实现 configureTasks 方法
     * 注册自定义的定时任务线程池
     * @param taskRegistrar the registrar to be configured
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        // 注册自定义的定时任务线程池
        taskRegistrar.setTaskScheduler(taskScheduler());
    }

    /**
     * 装配一个自定义的定时任务线程池
     * @return
     */
    @Bean
    public ThreadPoolTaskScheduler taskScheduler(){
        // 创建定时任务线程池
        ThreadPoolTaskScheduler poolTaskScheduler = new ThreadPoolTaskScheduler();
        // 设置池的线程大小
        poolTaskScheduler.setPoolSize(10);
        // 设置线程名称的前缀
        poolTaskScheduler.setThreadNamePrefix("任务线程-");
        return poolTaskScheduler;
    }
}
