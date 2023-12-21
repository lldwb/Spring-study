package org.example.invocation;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

@Setter
@Slf4j
public abstract class AgencyHandler {
    protected Object object;

    public abstract Object agency(Object proxy, Method method, Object[] args) throws Throwable;
}
