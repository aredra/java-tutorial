package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {

    private String name;
    private int age;
    private String job;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private List<ItemDto> items;

    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
