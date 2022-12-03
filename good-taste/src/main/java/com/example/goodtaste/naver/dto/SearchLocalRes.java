package com.example.goodtaste.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLocalRes {

    private String lastBuildDate;

    private int total;

    private int start;

    private int display;

    private List<SearchLocalItem> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchLocalItem {

        private String category;

        private String title;

        private String link;

        private String description;

        private String telephone;

        private String address;

        private String roadAddress;

        private int mapX;

        private int mapY;
    }
}
