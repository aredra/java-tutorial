package com.example.bookreview.service;

import com.example.bookreview.domain.Author;
import com.example.bookreview.domain.Book;
import com.example.bookreview.repository.AuthorRepository;
import com.example.bookreview.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final EntityManager entityManager;

    public void persistenceContext() {
        // 영속성 컨텍스트 - 더티 체킹(변경 감지), 1차 캐쉬, 지연 평가

        // 비영속 - 자바 객체
        Book book = new Book();
        // 영속
        entityManager.persist(book);
        // 준영속(detached) - 영속에서 벗어남,
        // close, clear 로도 가능 작업 대기중인 작업이 없어질 수 도 있음
        entityManager.detach(book);
        // 준영속을 명시적으로 반영
        entityManager.merge(book);
        // 제거
        entityManager.remove(book);
    }

    public void putBookAndAuthor() {
        Book book = new Book();
        book.setTitle("JPA tutorial");
        bookRepository.save(book);

        Author author = new Author();
        author.setName("Dev1");
        authorRepository.save(author);
    }

}
