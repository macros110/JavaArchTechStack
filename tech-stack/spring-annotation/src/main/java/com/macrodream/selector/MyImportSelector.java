package com.macrodream.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Macros.Zhang
 * @date 6/4/2022 21:57
 */
public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param importingClassMetadata 当前标注@Import注解类的所有注解信息
     * @return 返回值，就是导入到容器的组件全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        //方法不要返回null
        return new String[]{"com.macrodream.bean.Red","com.macrodream.bean.Green"};
    }
}
