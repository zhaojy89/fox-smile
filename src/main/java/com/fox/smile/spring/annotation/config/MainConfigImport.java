package com.fox.smile.spring.annotation.config;

import com.fox.smile.spring.annotation.bean.Color;
import com.fox.smile.spring.annotation.bean.Person;
import com.fox.smile.spring.annotation.bean.Red;
import com.fox.smile.spring.annotation.condition.LinuxCondition;
import com.fox.smile.spring.annotation.condition.MyImportBeanDefinitionRegistrar;
import com.fox.smile.spring.annotation.condition.MyImportSelector;
import com.fox.smile.spring.annotation.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;

@Import({Color.class, Red.class, MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfigImport {

}
