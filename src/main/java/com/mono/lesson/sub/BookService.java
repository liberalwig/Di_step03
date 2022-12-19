package com.mono.lesson.sub;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    protected BookRepository repository;

    Integer InitVal = 0;

    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void postConstructor() {
        System.out.println("++++++++++++++++++");
        System.out.println("BookService 초기화");
        System.out.println("++++++++++++++++++");

    Integer[] val = new Integer[]{1, 2, 3, 4, 5};
    // int a[] = {1,2,3,4,5};

    Optional<Integer> rslt = Arrays.stream(val).reduce((acc, num) -> acc += num);
    InitVal =rslt.get();
    }

    public void getVal() {
        System.out.println(InitVal);
    }

}
