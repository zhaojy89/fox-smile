package com.fox.smile.spring.annotation;

import com.fox.smile.spring.annotation.config.MainConfigCondition;
import com.fox.smile.spring.annotation.config.MainConfigImport;
import com.fox.smile.spring.annotation.config.MainConfigScan;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class IOCTest {

    @Test
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigScan.class);
        String [] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println("beanName=>"+beanName);
        }
    }

    @Test
    public void testIocCondition(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigCondition.class);
        Environment environment = applicationContext.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println("osName: "+osName);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName=>"+beanName);
        }
    }

    @Test
    public void testIocImport(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigImport.class);
        Environment environment = applicationContext.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println("osName: "+osName);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName=>"+beanName);
        }
    }

}
