package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Aware接口(感知型接口)，当spring容器发现某个bean
 * 实现了 Aware 接口以后，name 就会为这个 Bean 注入一些容器核心对象，
 * 比如某些业务场景中需要得到Bean的名字或者id时，可以通过该接口获取
 */
@Slf4j
@Service
public class UserService implements BeanNameAware {
    private String beanName;

    /**
     * 容器会通过这个set方法将bean的名字传进来
     *
     * @param beanName the name of the bean in the factory.
     *                 Note that this name is the actual bean name used in the factory, which may
     *                 differ from the originally specified name: in particular for inner bean
     *                 names, the actual bean name might have been made unique through appending
     *                 "#..." suffixes. Use the {@link BeanFactoryUtils#originalBeanName(String)}
     *                 method to extract the original bean name (without suffix), if desired.
     */
    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void add() {
        log.info("beanName" + beanName);
    }

    public void backup(){
        log.info("备份");
    }
}
