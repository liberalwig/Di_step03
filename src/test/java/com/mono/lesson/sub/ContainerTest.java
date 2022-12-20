package com.mono.lesson.sub;

import com.mono.config.ApplicationConfig1;
import com.mono.config.ApplicationConfig2;
import com.mono.config.ApplicationConfig3;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest
@ExtendWith(SpringExtension.class) // @ExtendWith: 스프링컨테이너 제작시 필요한 빈만 올려주는 기능
// @ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {ApplicationConfig3.class})
class ContainerTest {

    @Autowired
    ApplicationContext ctx;

    @AfterEach
    public void printBean() {
        System.out.println("===============Bean Names===============");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
    }

    @Test
    @DisplayName("Case1 : Xml + ComponentScan")
    void xmlWithContainer() {
        BookService service = ctx.getBean(BookService.class);

        System.out.println("===============Service InitVal===============");
        service.getVal();
        System.out.println("===============Repository DB Connection Validate===============");
        System.out.println(service.repository.getConnectionStatus());
    }

    @Test
    @DisplayName("Case2: Java Class + Bean Method")
    void classWithContainer1() {
        BookService service = ctx.getBean(BookService.class);

        // @PostConstruct
        System.out.println("===============Service InitVal===============");
        service.getVal();
        System.out.println("===============Repository DB Connection Validate===============");
        System.out.println(service.repository.getConnectionStatus());

        BookRepository bookRepository1 = ctx.getBean(BookRepository.class, "bookRepository");
        BookRepository bookRepository2 = ctx.getBean(BookRepository.class, "bookRepository1");
        System.out.println(bookRepository1);
        System.out.println(bookRepository2);
    }

    @Test
    @DisplayName("Case3: Java Class + String ComponentScan") // 문제점: typeSafe 하지 않다. 실행해봐야 오류를 그제서야 냄
    void classWithContainer2() {
        BookService service = ctx.getBean(BookService.class);

        // @PostConstruct
        System.out.println("===============Service InitVal===============");
        service.getVal();
        System.out.println("===============Repository DB Connection Validate===============");
        System.out.println(service.repository.getConnectionStatus());
    }

    @Test
    @DisplayName("Case4 : Java Class + Typesafe ComponentScan")
    void classWithContainer3() {
        BookService service = ctx.getBean(BookService.class);

        // @PostConstruct
        System.out.println("===============Service InitVal===============");
        service.getVal();
        System.out.println("===============Repository DB Connection Validate===============");
        System.out.println(service.repository.getConnectionStatus());
    }

    @Test
    @DisplayName("Case5: SpringBoot ComponentScan")
    void classWithContainer4() {
        ctx = new AnnotationConfigApplicationContext(LessonApplication.class, ApplicationConfig3.class);
    }
}