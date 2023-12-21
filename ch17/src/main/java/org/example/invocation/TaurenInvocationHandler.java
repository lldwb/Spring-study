package org.example.invocation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 回调处理器，需要继承 InvocationHandler
 * 负责调用被代理类的所有方法，进行一些增强的逻辑
 */
@Slf4j
public class TaurenInvocationHandler implements InvocationHandler {
    /**
     * 目标对象(被代理对象)
     */
    private Object target;

    /**
     * 通过构造方法传入目标对象
     *
     * @param object
     */
    public TaurenInvocationHandler(Object object) {
        this.target = object;
    }

    /**
     * 核心的回调方法，目的是负责调用目标对象的行为
     * 这样可以在调用目标方法前后额外执行一些增强的逻辑
     *
     * 动态代理对象去调用
     *
     * @param proxy  由 jdk 动态创建出来的代理对象
     * @param method 目标对象的具体方法
     * @param args   目标对象的参数(动态数组)
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue;

        /**
         * 反射调用目标对象的方法
         * target 被调用对象
         * args 参数
         * 返回被调用对象的方法调用后的返回值
         */
        log.debug("ntr");
        returnValue = method.invoke(target, args);
        return returnValue;
    }
}
