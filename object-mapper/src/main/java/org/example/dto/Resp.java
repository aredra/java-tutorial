package org.example.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class Resp {

    private String resultCode;

    private Body resultBody;

    @Data
    @Accessors(chain = true)
    public static class Body {
        private int result;
    }
}
