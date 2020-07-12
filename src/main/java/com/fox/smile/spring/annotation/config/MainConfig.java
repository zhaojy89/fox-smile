package com.fox.smile.spring.annotation.config;

import com.fox.smile.spring.annotation.bean.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 配置类，等同于之前的配置文件
 */
@Configuration //告诉spring当前类为配置类
@ComponentScan(value = "com.fox.smile.spring.annotation",
 excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class,Service.class}) })
// @ComponentScan value: 指定spring要扫描的包路径
// excludeFilters: Filter[] 数组,指定要排除的规则
public class MainConfig {

    @Bean(value = "person") //给容器注册一个bean; bean类型为返回值类型，beanName为方法名; bean注解指定了名称，则优先使用注解配置的bean名称
    public Person person01(){
        return new Person("simo", 20);
    }
}
