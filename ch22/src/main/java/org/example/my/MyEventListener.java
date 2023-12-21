package org.example.my;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 自定义事件监听器，用于监听用户发布的事件并进行处理，
 * 监听器需要纳入容器管理
 */
@Slf4j
@Component
public class MyEventListener {
    /**
     * 自定义事件监听方法，容器会将用户发布的事件对象传入这个方法中进行事件处理
     * @EventListener 用于标识当前方法为监听方法
     * @param event
     */
    @EventListener
    public void handlerEvent(MyEvent event){
        log.info(event.getMessage());
    }
}
