package com.sraynitjsr.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class MySpringCoreMain {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySpringCoreMain.class)) {            
            MyBean myBean = context.getBean(MyBean.class);
            myBean.doSomething();
        }
    }
}
