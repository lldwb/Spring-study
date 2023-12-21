package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

class TaurenUtilTest {

    @Test
    void ntr() {
        Malelead malelead = TaurenUtil.ntr(new Queen());
//        TaurenInvocationHandler handler = new TaurenInvocationHandler(new Queen());
//        Malelead malelead = (Malelead) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Malelead.class},handler);
        /**
         * 调用代理对象的任何方法，都会去调用回调处理器的 invoke 方法来完成代理的调用
         */
        malelead.video();
    }
}