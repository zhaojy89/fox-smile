package com.fox.smile.spring.annotation;

import com.fox.smile.spring.annotation.bean.Person;
import com.fox.smile.spring.annotation.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        //通过配置文件方式注入bean
        /*
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring/beans.xml");
        Person person = (Person) xmlApplicationContext.getBean("person");
        System.out.println("person=>"+person);

        Person person1 = (Person) xmlApplicationContext.getBean("person1");
        System.out.println("person1=>"+person1);
         */

        //通过注解方式注入bean
        ApplicationContext annotationApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person2 = annotationApplicationContext.getBean(Person.class);
        System.out.println("person2=>"+person2);

        String[] namesForType = annotationApplicationContext.getBeanNamesForType(Person.class);
        for (String beanName : namesForType) {
            System.out.println("beanName=>"+beanName);
        }
    }

}
