package top.lldwb.spring.ch04.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean 的后置处理器，后置处理器的方法分别
 * 在调用初始化方法执行前的和执行后
 * 注意 后置处理器的方法是针对所有的 Bean 对象，而不是单独的某一个 Bean
 */
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 在初始化方法前
     * @param bean the new bean instance
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.debug("在初始化方法前");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 在初始化方法后
     * @param bean the new bean instance
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.debug("在初始化方法后");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
