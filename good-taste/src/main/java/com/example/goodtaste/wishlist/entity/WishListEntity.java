package com.example.goodtaste.wishlist.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity(name = "wish_list")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class WishListEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String category;

    private String address;

    private String roadAddress;

    private String homePageLink;

    private String imageLink;

    private boolean isVisit;

    private int visitCount;

    private LocalDateTime lastVisitDate;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

}
