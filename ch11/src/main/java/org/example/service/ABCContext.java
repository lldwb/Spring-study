package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class ABCContext {
    /**
     * 注入 map 集合中，spring 会将 所有实现类 注入集合中
     * 集合中 key(Bean的id) value(实现类的对象)
     * 根据集合中的 value 类型去进行查找并注入依赖
     *
     * 为什么不使用 List 而是使用 Map，因为 List 不能存储 Bean 的 ID
     */
    private final Map<String, ABC> map;

    public void context(String abcType) {
        log.debug("选择对应的算法");
        for (String key : map.keySet()) {
            log.debug(key);
            if (key.equals(abcType)) {
                map.get(key).abc();
            }
        }
    }
}
