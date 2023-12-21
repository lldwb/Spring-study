package org.example;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

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
//        return (Connection) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Connection.class}, new ConnectionInvocationHandler(connection, pool));
        return (Connection) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Connection.class}, (proxy, method, args) -> {
            if ("close".equals(method.getName())) {
                pool.addLast((Connection) proxy);
                return null;
            } else {
                return method.invoke(connection, args);
            }
        });
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
