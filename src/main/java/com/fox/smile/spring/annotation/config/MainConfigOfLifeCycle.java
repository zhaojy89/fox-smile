package com.fox.smile.spring.annotation.config;

import com.fox.smile.spring.annotation.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@ComponentScan("com.fox.smile.spring.annotation.bean")
@Configuration
public class MainConfigOfLifeCycle {

    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

}
