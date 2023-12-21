package org.example;

import org.example.invocation.TaurenInvocationHandler;

import java.lang.reflect.Proxy;

public class TaurenUtil {

    public static <T> T ntr(T t) {
        /**
         * 通过 JDK 提供的 Proxy 类来动态创建代理对象
         * newProxyInstance 方法需要提供三个参数
         * 参数1：需要提供一类加载器去加载动态创建出来的代理字节码，从而实例化一个代理对象
         * 参数2：目标对象属性的所有接口的 Class，因为 JDK 动态代理是一定要根据接口来创建一个代理对象，创建出来的这个代理对象会自动实现这些接口
         * 参数3：自定义的回调处理器
         * 返回的 就是已经创建好的对象
         *
         * 为什么需要类加载器：
         * class 是类加载器 到 JVM
         * 类加载器是 class(自解码文件) -> byte[](字节数组) -> JVM(创建成 class对象)
         * 类加载器的目的是为了加载字节数组
         * 而 JDK动态代理 是通过类加载器 创建 class对象 并实现被代理对象的所有接口
         *
         * 总结：目标对象一定要实现接口，否则无法创建代理对象，因为JDK动态代理是基于接口来生成代理对象
         *
         *
         * 为什么需要类加载器？
         * 因为在运行时动态创建出来的代理对象是一个字节数组，需要类加载器去加载到jvm创建成class对象，我们才能实例化对象进行操作
         *
         * 而 new 的过程是根据 class对象(根据字节数组生成包含类信息的对象) 创建对应的对象
         * 查找并判断JVM是否有加载 class对象，如果没有就查找 class文件 加载到 JVM(class文件转换成字节数组，字节数组转换成class对象)
         * User u1 = new User();
         *
         * User u2 = new User();
         *
         * JDK动态代理：从字节数组开始创建代理对象的
         */
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new TaurenInvocationHandler(t));
    }
}
