package com.mono.lesson.sub;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private Boolean connectionStatus = false;


    public BookRepository() {
        System.out.println("BookRepository 생성자 호출됨");
    }

    public Book save(Book book) {
        return null;
    }

    public Boolean getConnectionStatus() {
        return connectionStatus;
    }

    @PostConstruct
    public void postConstructor() {
        System.out.println("++++++++++++++++++");
        System.out.println("BookRepository 초기화");
        System.out.println("BookRepository : " + this);
        this.connectionStatus = true;
        System.out.println("++++++++++++++++++");
    }
}
