package com.example.bookreview.service;

import com.example.bookreview.repository.AuthorRepository;
import com.example.bookreview.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @Test
    void transactionTest() {

        try {

        bookService.putBookAndAuthor();
        } catch (RuntimeException e) {

        }

    }

}