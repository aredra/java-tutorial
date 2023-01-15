package com.example.bookreview.repository;

import com.example.bookreview.domain.Book;
import com.example.bookreview.repository.dto.BookCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.publisher = ?1 and b.publishedAt >= ?2 and b.outOfPrintAt <= ?3")
    List<Book> findByPublisherWithDate1(String publisherId, OffsetDateTime publishedAt, OffsetDateTime outOfPrintAt);

    @Query("select b from Book b where b.publisher = :publihserId and b.createdAt >= :createdAt and b.outOfPrintAt <=" +
            " :outOfPrintAt")
    List<Book> findByPublisherWithDate2(
            @Param("publisherId") String publisherId,
            @Param("publishedAt") OffsetDateTime publishedAt,
            @Param("outOfPrintAt") OffsetDateTime outOfPrintAt);

    @Query("select new com.example.bookreview.repository.dto.BookCategoryDto(b.title, b.category) from Book b")
    List<BookCategoryDto> findBookAndCategory();

    @Query(value = "select * from book", nativeQuery = true)
    List<Book> findNativeQueryBook();

    @Transactional
    @Modifying
    @Query(value = "update book set category = 'IT'", nativeQuery = true)
    int updatedBookCategoryWithIt();

    @Query(value = "show tables", nativeQuery = true)
    List<String> showTables();
}
