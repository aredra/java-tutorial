package com.example.bookreview.repository.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCategoryDto {

    private String title;

    private String category;
}
