package com.example.bookreview.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    // TODO M:N 은 하나의 테이블을 만들어서 중간 매핑 테이블 제거할 수 있다.
    @ManyToMany
    private List<Book> books = new ArrayList<>();


    public void addBooks(Book... books) {
        Collections.addAll(this.books, books);
    }
}
