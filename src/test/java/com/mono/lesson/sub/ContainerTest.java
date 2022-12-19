package com.mono.lesson.sub;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
// @ContextConfiguration(classes = {ApplicationConfig1.class})
class ContainerTest {

    @Autowired
    ApplicationContext ctx;

    @AfterEach
    public void printBean() {
        System.out.println("===============bean names===============");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
    }

    @Test
    @DisplayName("Case1 : Xml + Component Scan")
    void xmlWithContainer() {

        BookService service = ctx.getBean(BookService.class);
        System.out.println("===============Service initVal===============");
        service.getVal();
        System.out.println("===============Repository DB Connection Validate===============");
        System.out.println(service.repository.getConnectionStatus());
    }

    @Test
    @DisplayName("Case2: Java Calss + Bean Method")
    void classWithContainer1() {

    }
}