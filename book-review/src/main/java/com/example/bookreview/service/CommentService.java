package com.example.bookreview.service;

import com.example.bookreview.domain.Comment;
import com.example.bookreview.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    // readOnly - dirtyCheck 를 안한다.
    @Transactional(readOnly = true)
    public void updateSomething() {
        List<Comment> comments = commentRepository.findAll();

        comments.forEach(comment -> {
            comment.setComment("Good");
        });
    }

    @Transactional
    public void insertSomething() {
        Comment comment = new Comment();
        comment.setComment("Best");

        commentRepository.save(comment);
    }

}
