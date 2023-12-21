package org.example;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

@Slf4j
@Setter
public class ConnectionPool {

    /**
     * 连接池(存放连接的集合)
     * <p>
     * 链表(前面拿后面放)
     */
    private LinkedList<Connection> pool = new LinkedList<>();

    private String url;
    private String userName;
    private String password;
    private Integer size;

    public void init() {
        connections();
    }

    /**
     * 根据size添加数据到连接池中
     */
    private void connections() {
        try {
            for (int i = 0; i < size; i++) {
                // 从数据库获取连接对象
                Connection connection = DriverManager.getConnection(url, userName, password);
                // 将连接对象返给池中
                pool.add(createProxy(connection));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 给连接对象套代理
     *
     * @param connection
     * @return
     */
    private Connection createProxy(Connection connection) {
        // 创建代理生成器
        Enhancer enhancer = new Enhancer();
        // 要告诉代理生成器需要登录的父类
        enhancer.setSuperclass(Connection.class);
        /**
         * 设置方法拦截器(设置回调方法)
         *
         * proxy：代理对象
         * method：父类方法
         * args：参数
         * methodProxy：子类方法
         *
         * 注意：调用时，调用子类的代理方法不要调用父类方法(method)
         */
        enhancer.setCallback((MethodInterceptor) (proxy, method, args, methodProxy) -> {
            if ("close".equals(method.getName())) {
                pool.addLast((Connection) proxy);
                return null;
            } else {
                return methodProxy.invoke(connection, args);
            }
        });
        // 创建代理对象(运行时动态创建的子类对象就是代理对象)
        return (Connection) enhancer.create();
    }

    /**
     * 从池里面获取代理连接
     *
     * @return
     */
    public Connection getConnection() {
        if (size() <= 0) {
            connections();
        }
        return pool.removeFirst();
    }

    /**
     * 查看连接池的大小
     *
     * @return
     */
    public int size() {
        return pool.size();
    }
}
