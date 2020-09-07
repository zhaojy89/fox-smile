package com.fox.smile.spring.annotation.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

    // 返回一个color对象，对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    // 返回的类型
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    // true 单实例，容器中保存一份
    // false 多实例，getObject()每次获取，都会创建一个新的bean;
    @Override
    public boolean isSingleton() {
        return true;
    }

}
