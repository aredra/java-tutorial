package com.example.bookreview.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@DynamicUpdate
@NoArgsConstructor
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    private String category;

    private OffsetDateTime publishedAt;

    private OffsetDateTime outOfPrintAt;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    private List<Author> authors = new ArrayList<>();

}
