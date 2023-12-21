package org.example.invocation.impl;

import org.example.invocation.AgencyHandler;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {
    private AgencyHandler agencyHandler;

    public InvocationHandlerImpl(AgencyHandler agencyHandler) {
        this.agencyHandler = agencyHandler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return agencyHandler.agency(proxy,method,args);
    }
}
