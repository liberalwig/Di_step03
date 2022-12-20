package com.mono.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.mono.lesson"}) // lesson 패키지 내 모든 클래스를 빈 객체화 함
public class ApplicationConfig2 {
}
