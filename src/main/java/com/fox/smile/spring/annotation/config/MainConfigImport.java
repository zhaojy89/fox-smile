package com.fox.smile.spring.annotation.config;

import com.fox.smile.spring.annotation.bean.Color;
import com.fox.smile.spring.annotation.bean.Red;
import com.fox.smile.spring.annotation.condition.MyImportBeanDefinitionRegistrar;
import com.fox.smile.spring.annotation.condition.MyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Color.class, Red.class, MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfigImport {

}
