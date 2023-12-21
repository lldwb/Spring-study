package org.example;

import org.example.controller.UserController;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义导入选择器
 */
public class AnnoImportSelector implements ImportSelector {
    /**
     *
     * @param importingClassMetadata
     * @return 返回值就是所有需要导入的类的完整类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 创建一个集合保存带有注解的类的完整类名
        List<String> classNameList = new ArrayList<>();
//        if ()
        classNameList.add(UserController.class.getName());
        return StringUtils.toStringArray(classNameList);
    }
}
