package org.example.invocation;

import org.example.invocation.impl.InvocationHandlerImpl;
import org.example.invocation.impl.MethodInterceptorImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.Proxy;

public class AgencyUtil {

    public static <T> T getObject(T t, AgencyHandler handler) {
        handler.setObject(t);
        Class<?> clazz = t.getClass();
        if (clazz.getInterfaces().length == 0) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(clazz);
            enhancer.setCallback(new MethodInterceptorImpl(handler));
            return (T) enhancer.create();
        } else {
            return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandlerImpl(handler));
        }
    }
}
