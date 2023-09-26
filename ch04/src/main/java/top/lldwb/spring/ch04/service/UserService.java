package top.lldwb.spring.ch04.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class UserService implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        log.debug("销毁");
    }
    public void destroys() throws Exception {
        log.debug("自定义销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // Bean的初始化方法，在构造方法后执行
        log.debug("Bean初始化,执行afterPropertiesSet");
    }
    public void afterPropertiesSets() throws Exception {
        // Bean的初始化方法，在构造方法后执行
        log.debug("Bean初始化,执行afterPropertiesSets");
    }

    public UserService() {
        log.debug("初始化");
    }

    public void save() {
        log.info("输出save");
    }
}
