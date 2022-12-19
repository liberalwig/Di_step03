package com.mono.config;

import com.mono.lesson.sub.LessonApplication;
import com.mono.scantest.ScanClass1;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {LessonApplication.class, ScanClass1.class})
public class ApplicationConfig3 {
}
