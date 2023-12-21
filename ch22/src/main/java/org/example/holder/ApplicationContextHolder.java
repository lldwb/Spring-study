package org.example.holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 用于获取 ApplicationContext 容器
 * 实现 ApplicationContextAware 接口
 * 这样 spring 容器将感知到当前的 Bean 需要注入一个容器对象
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    /**
     * 通过set方法将容器本身注入进来
     *
     * @param appContext the ApplicationContext object to be used by this object
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        applicationContext = appContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 封装容器中的三个getBean方法
     */
    public static Object getBean(String id) {
        return applicationContext.getBean(id);
    }
    public static <T> T getBean(String id, Class<T> clazz) {
        return applicationContext.getBean(id, clazz);
    }
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
