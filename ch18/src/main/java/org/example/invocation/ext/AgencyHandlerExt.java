package org.example.invocation.ext;

import lombok.extern.slf4j.Slf4j;
import org.example.invocation.AgencyHandler;

import java.lang.reflect.Method;

@Slf4j
public class AgencyHandlerExt extends AgencyHandler {
    @Override
    public Object agency(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("调用前：" + object.getClass().getSimpleName());
        Object objectValue = method.invoke(object, args);
        log.info("调用前：" + object.getClass().getSimpleName());
        return objectValue;
    }
}
