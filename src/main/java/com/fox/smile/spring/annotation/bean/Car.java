package com.fox.smile.spring.annotation.bean;

public class Car {

    public Car(){
        System.out.println("car constuctor......");
    }

    public void init(){
        System.out.println("car ... init ...");
    }

    public void destroy() {
        System.out.println("car ... destroy ...");
    }

}
