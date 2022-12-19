package com.mono.lesson.sub;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    private Date created;
    private BookStatus bookStatus;

}
