package com.fox.smile.spring.annotation.condition;

import com.fox.smile.spring.annotation.bean.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        boolean hasRed = beanDefinitionRegistry.containsBeanDefinition("com.fox.smile.spring.annotation.bean.Red");
        boolean hasBlue = beanDefinitionRegistry.containsBeanDefinition("com.fox.smile.spring.annotation.bean.Blue");

        //如果容器中同时存在red和blue，则注册rainBow
        if (hasRed && hasBlue) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            beanDefinitionRegistry.registerBeanDefinition("rainBow", beanDefinition);
        }

    }

}
