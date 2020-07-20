package com.fox.smile.spring.annotation.config;

import com.fox.smile.spring.annotation.bean.Person;
import com.fox.smile.spring.annotation.service.BookService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 配置类，等同于之前的配置文件
 */
@Configuration //告诉spring当前类为配置类
@ComponentScan(value = "com.fox.smile.spring.annotation",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class,Service.class}) },
        //includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})},
        useDefaultFilters = false)
@ComponentScans(value = {
        @ComponentScan(value = "com.fox.smile.spring.annotation",
                //excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class,Service.class}) },
                includeFilters = {
                        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
                },
                useDefaultFilters = false)
})
// @ComponentScan 项目配置为jdk1.8以上进行编译,该注解可写多个,指定多个扫描规则
// 项目配置为jdk1.8jdk1.8以下编译，@ComponentScans配置多个扫描规则, value数组配置多个@ComponentScan注解
// @ComponentScans 可以与一个@ComponentScan同时在一个类中注解，@ComponentScan 配置2个及以上时，则报警【ComponentScans must not be present at the same time as the element it contains】
// value: 指定spring要扫描的包路径
// excludeFilters: Filter[] 数组,扫描包时根据指定规则排除组件
// includeFilers: Filter[] 数组，扫描包是根据规则只包含对应组件
// useDefaultFilters: 设置为false,禁用默认规则,使用includeFilters生效
// FilterType.ANNOTATION 按照注解 常用
// FilterType.ASSIGNABLE_TYPE 按照给定的类型
// FilterType.ASPECTJ  ASPECTJ表达式，不常用
// FilterType.REGEX 正则表达式，不常用
// FilterType.CUSTOM 自定义方式
public class MainConfig {

    @Bean(value = "person") //给容器注册一个bean; bean类型为返回值类型，beanName为方法名; bean注解指定了名称，则优先使用注解配置的bean名称
    public Person person01(){
        return new Person("simo", 20);
    }
}
