package com.example.bookreview.repository;

import com.example.bookreview.domain.BookReview;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {

    @Query("select distinct br from BookReview br join fetch br.comments")
    List<BookReview> findAllByFetchJoin();

    @EntityGraph(attributePaths = "comments")
    @Query("select br from BookReview br")
    List<BookReview> findAllByEntityGraph();
}
