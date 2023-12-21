package org.example.invocation.impl;

import org.example.invocation.AgencyHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MethodInterceptorImpl implements MethodInterceptor {
    private AgencyHandler agencyHandler;

    public MethodInterceptorImpl(AgencyHandler agencyHandler) {
        this.agencyHandler = agencyHandler;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        return agencyHandler.agency(proxy,method,args);
    }
}
