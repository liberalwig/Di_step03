package com.mono.config;

import com.mono.lesson.sub.BookRepository;
import com.mono.lesson.sub.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig1 {

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

    @Bean
    @Primary
    public BookRepository bookRepository1() {
        return new BookRepository();
    }

    @Bean
    public BookService bookService() {
        BookService bookService = new BookService();

        // @Autowired 사용 안 하는 경우에 아래 라인 작성
        bookService.setRepository(bookRepository1());
        return bookService;
    }
}
