package com.mono.lesson.sub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LessonApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(LessonApplication.class, args);
        System.out.println("===============Container 등록 Bean Start===============");
        System.out.println("===============Container 등록 Bean End===============");
    }
}
