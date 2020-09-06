package com.fox.smile.spring.annotation.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        String[] memberClassNames = annotationMetadata.getMemberClassNames();
        String[] interfaceNames = annotationMetadata.getInterfaceNames();
        String superClassName = annotationMetadata.getSuperClassName();
        return new String[]{"com.fox.smile.spring.annotation.bean.Blue"};
    }

}
