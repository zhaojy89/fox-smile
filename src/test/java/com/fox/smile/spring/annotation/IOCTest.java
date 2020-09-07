package com.fox.smile.spring.annotation;

import com.fox.smile.spring.annotation.config.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class IOCTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigScan.class);
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
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigImport.class);
        Environment environment = applicationContext.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println("osName: "+osName);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName=>"+beanName);
        }
    }

    @Test
    public void testIocFactoryBean(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigFactoryBean.class);

        // 工厂bean获取的是调用getObject创建的对象
        Object bean1 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean1->"+bean1.getClass());

        Object bean2 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean2->"+bean2.getClass());
        System.out.println(bean1 == bean2);

        Object bean3 = applicationContext.getBean("&colorFactoryBean");
        System.out.println("bean3->"+bean3.getClass());
    }

    @Test
    public void testIocLifeCycle(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");

        applicationContext.close();;
        System.out.println("容器关闭...");
    }

}
