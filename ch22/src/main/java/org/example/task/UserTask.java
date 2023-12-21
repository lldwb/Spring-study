package org.example.task;

import lombok.RequiredArgsConstructor;
import org.example.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器
 */
@Component
@RequiredArgsConstructor
public class UserTask {
    private final UserService userService;

    /**
     * 定时任务的方法
     * @Scheduled 标注为定时任务
     * 并且使用 cron表达式 来设定执行的时间
     * 执行也有时间
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void executeBackup(){
        userService.backup();
    }
}
