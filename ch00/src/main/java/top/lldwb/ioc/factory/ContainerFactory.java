package top.lldwb.ioc.factory;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import lombok.extern.slf4j.Slf4j;
import top.lldwb.ioc.Bean;
import top.lldwb.ioc.Inject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ContainerFactory {

    /**
     * 单例容器
     */
    private static Map<String, Object> container = new HashMap<>();
    /**
     * 原型容器
     */
    private static Map<String, Class<?>> archetype = new HashMap<>();

    /**
     * 初始化容器
     * 参数表示要管理的包路径
     */
    public ContainerFactory(String... packages) {
        List<Class<?>> classList = scan(packages);
        resolveClass(classList);
    }

    /**
     * 扫描指定的包，并返回相关的Class对象
     *
     * @param packages
     * @return
     */
    private List<Class<?>> scan(String... packages) {
        try (ScanResult scan = new ClassGraph().enableAllInfo().acceptPackages(packages).scan()) {
            return scan.getAllClasses().loadClasses();
        }
    }

    /**
     * 解析class集合，找到带有@Bean注解的类
     */
    private void resolveClass(List<Class<?>> classList) {
        classList.forEach(clazz -> {
            if (clazz.isAnnotationPresent(Bean.class)) {
                Bean bean = clazz.getAnnotation(Bean.class);
                // 获取 Bean 的作为 k
                String k = bean.value();
                // 判断是否需要唯一
                if (bean.sole()) {
                    // 唯一，添加到单例容器
                    container.put(k, newInstance(clazz));
                } else {
                    // 不唯一，添加到原型容器
                    archetype.put(k, clazz);
                }
            }
        });
    }

    /**
     * 创建实例
     *
     * @param clazz 类
     * @return
     */
    private static Object newInstance(Class<?> clazz) {
        try {
            return clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("实例创建失败:", e);
        }
    }

    /**
     * 容器工厂方法
     */
    public static Object getBean(String name) {
        Object object = null;
        // 判断单例容器中是否有
        if (container.containsKey(name)) {
            object = container.get(name);
        } else {
            object = newInstance(archetype.get(name));
        }

        if (object == null) {
            throw new RuntimeException();
        }

        inject(object);
        return object;
    }

    /**
     * 容器工厂方法
     */
    public static <T> T getBean(String name, Class<T> tClass) {
        T t = null;
        // 判断单例容器中是否有
        if (container.containsKey(name)) {
            t = (T) container.get(name);
        } else {
            t = (T) newInstance(archetype.get(name));
        }

        if (t == null) {
            throw new RuntimeException();
        }

        inject(t);
        return t;
    }

    /**
     * 容器工厂方法
     */
    public static <T> T getBean(Class<T> tClass) {
        // 判断单例容器中是否有
        T t = null;
        for (Object objects : container.values()) {
            // 判断是否可以进行类型转换
            if (tClass.isInstance(objects)) {
                if (t != null) {
                    throw new RuntimeException();
                }
                t = (T) objects;
            }
        }
        for (Class<?> clazz : archetype.values()) {
            // 判断是否可以进行类型转换
            try {
                Object objects = clazz.newInstance();
                if (tClass.isInstance(objects)) {
                    if (t != null) {
                        throw new RuntimeException();
                    }
                    t = (T) objects;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            }
        }
        if (t == null) {
            throw new RuntimeException();
        }

        inject(t);
        return t;
    }

    /**
     * 进行依赖注入
     * @param object
     * @return
     */
    private static Object inject(Object object) {
        log.debug("进行依赖注入");
        for (Field field : object.getClass().getDeclaredFields()) {
            log.debug("field" + field.getName());
            if (field.isAnnotationPresent(Inject.class)) {
                Inject inject = field.getAnnotation(Inject.class);
                Object value = null;
                if (inject.value() != "") {
                    value = getBean(inject.value());
                }else {
                    value = getBean(field.getType());
                }
                try {
                    field.setAccessible(true);
                    field.set(object, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return object;
    }
}