package org.example.invocation;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionInvocationHandler implements InvocationHandler {
    private Object object;
    private LinkedList<Connection> pool;

    public ConnectionInvocationHandler(Object object, LinkedList<Connection> pool) {
        this.object = object;
        this.pool = pool;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("close".equals(method.getName())) {
            pool.addLast((Connection) proxy);
            return null;
        } else {
            return method.invoke(object, args);
        }
    }
}
