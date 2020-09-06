package com.fox.smile.spring.annotation.config;

import com.fox.smile.spring.annotation.bean.Person;
import com.fox.smile.spring.annotation.condition.LinuxCondition;
import com.fox.smile.spring.annotation.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@Conditional(WindowsCondition.class)
public class MainConfigCondition {

    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person bill(){
        return new Person("bill", 23);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person linus(){
        return new Person("linus", 54);
    }

}
