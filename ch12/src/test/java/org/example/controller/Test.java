package org.example.controller;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.annotation.Bean;

public class Test {
    public static void main(String[] args) {
        // 创建目标对象
        UserDao target = new UserDao("旧的对象");

        // 获取增强对象
        Enhancer enhancer = new Enhancer();
        // 用于设置enhancer对象的父类
        enhancer.setSuperclass(UserDao.class);
        // 设置enhancer对象的回调函数
        // 使用了MethodInterceptor接口的一个实现类，重写了intercept()方法，
        // 实现了代理对象的具体逻辑，包括开启事务、调用目标对象的方法、提交事务等。
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            Object returnValue;
            System.out.println("开启事务");
            if (method.isAnnotationPresent(Bean.class)) {
                if (target.getUserDao() == null) {
                    // 执行目标对象方法
//                    target.setUserDao(target);
                    target.setUserDao(new UserDao("新的对象"));
                }
                returnValue = method.invoke(target.getUserDao(), args1);
            } else {
                returnValue = method.invoke(target, args1);
            }
            System.out.println("提交事务");
            return returnValue;
        });

        // 创建代理对象(代理类是被代理类的子类)
        UserDao proxy = (UserDao) enhancer.create();

        // 调用代理对象方法
        proxy.save();
        proxy.save();
        proxy.save();
        proxy.save1();
    }
}

/**
 * 目标对象
 */
class UserDao {
    private static UserDao userDao = null;

    public static UserDao getUserDao() {
        return userDao;
    }

    public static void setUserDao(UserDao userDao) {
        UserDao.userDao = userDao;
    }

    private String string;

    public UserDao() {
        this.string = "保存用户";
    }

    public UserDao(String string) {
        this.string = string;
    }

    @Bean
    public void save() {
        System.out.println("save" + this);
        System.out.println(string);
    }

    public void save1() {
        System.out.println("save1" + this);
        System.out.println(string);
    }
}