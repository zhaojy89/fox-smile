package com.fox.smile.spring.annotation.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        conditionContext.getBeanFactory();
        conditionContext.getClassLoader();
        Environment environment = conditionContext.getEnvironment();
        conditionContext.getRegistry();

        String osName = environment.getProperty("os.name");
        if (osName.contains("Windows")) {
            return true;
        }
        return false;
    }

}
