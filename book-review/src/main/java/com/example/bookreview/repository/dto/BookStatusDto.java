package com.example.bookreview.repository.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookStatusDto {

    private int code;

    private String description;

    public BookStatusDto(int code) {
        this.code = code;
        this.description = parseDescription(code);
    }

    public boolean isDisplayed() {
        return code == 200;
    }

    private String parseDescription(int code) {
        switch (code) {
            case 100:
                return "Sold out";
            case 200:
                return "Sales";
            default:
                return "Unknown";
        }
    }
}
