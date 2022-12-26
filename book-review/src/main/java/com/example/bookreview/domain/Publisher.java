package com.example.bookreview.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int establishedYear;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private List<Book> books = new ArrayList<>();

    public void addBooks(Book... books) {
        Collections.addAll(this.books, books);
    }
}
