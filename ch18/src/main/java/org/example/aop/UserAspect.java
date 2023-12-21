package org.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * 增强的类型
 * 前置(目标方法调用前)：需要实现 MethodBeforeAdvice 接口
 * 后置(目标方法调用后)：需要实现 AfterReturningAdvice 接口
 * 环绕(在调用前后执行)：需要实现 MethodInterceptor 接口
 * 异常(出现异常调用，不执行后置)：需要实现 ThrowsAdvice 接口
 * 最终(始终执行) [Spring早期没有]
 */
@Slf4j
public class UserAspect implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor, ThrowsAdvice {
    /**
     * 前置通知
     *
     * @param method 被调用的方法
     * @param args   方法的参数
     * @param target 目标对象
     * @throws Throwable 抛出异常
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.info("前置通知...");
    }

    /**
     * 后置通知
     *
     * @param returnValue 返回的值
     * @param method      被调用的方法
     * @param args        方法的参数
     * @param target      目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        log.info("后置通知...");
    }

    /**
     * 环绕通知
     *
     * @param invocation 回调处理器，用于调用目标对象的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("环绕通知前");
        Object returnValue = invocation.getMethod();
        log.info("环绕通知后");
        return returnValue;
    }

    /**
     * 异常通知，根据官方文档说明
     * 改方法名必须叫做 afterThrowing
     * 并且必须包括一个 Exception 参数
     *
     * @param e
     */
    public void afterThrowing(Exception e) {
        log.info("异常通知" + e.getMessage());
    }
}
