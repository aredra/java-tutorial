package com.example.hello;

import com.example.hello.dto.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("----- Object mapper -----");

        var objectMapper = new ObjectMapper();

        // object -> text
        // get method 를 활용
        var user = new UserRequest("test", "dev", 999);
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // default 생성자를 필요
        var objectUser = objectMapper.readValue(text, UserRequest.class);
        System.out.println(objectUser);
    }

}
