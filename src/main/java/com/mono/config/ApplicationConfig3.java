package com.mono.config;

import com.mono.lesson.sub.LessonApplication;
import com.mono.scantest.ScanClass1;
import com.mono.scantest.ScanClass2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {LessonApplication.class, ScanClass2.class})
public class ApplicationConfig3 {
}