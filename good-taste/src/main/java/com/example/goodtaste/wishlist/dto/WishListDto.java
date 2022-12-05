package com.example.goodtaste.wishlist.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class WishListDto {

    private Integer index;

    private String title;

    private String category;

    private String address;

    private String roadAddress;

    private String homePageLink;

    private String imageLink;

    private boolean isVisit;

    private int visitCount;

    private LocalDateTime lastVisitDate;

}