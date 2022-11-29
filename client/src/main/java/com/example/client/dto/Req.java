package com.example.client.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Req<T> {

    private Header header;

    private T body;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header {
        private String responseCode;
    }
}
