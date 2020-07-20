package com.fox.smile.spring.annotation.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义过滤规则
 */
public class MyTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader 读取到当前正在扫描的类信息
     * @param metadataReaderFactory 可以获取到其他任何类信息的
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类注解的信息
        AnnotatedTypeMetadata annotatedTypeMetadata = metadataReader.getAnnotationMetadata();

        // 获取当前正在扫描的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        classMetadata.getEnclosingClassName();

        // 获取当前类资源信息
        Resource resource = metadataReader.getResource();
        String fileName = resource.getFilename();
        String url = resource.getURL().toString();
        String desc = resource.getDescription();
        //System.out.println("fileName-->"+fileName+",url-->"+url+",desc-->"+desc);

        String className = classMetadata.getClassName();
        System.out.println("className-->"+className);

        // 类名包含er时注入到容器中
        if (className.contains("er")) {
            return true;
        }
        return false;
    }

}
