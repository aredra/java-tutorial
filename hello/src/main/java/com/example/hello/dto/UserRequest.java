package com.example.hello.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {

    @ApiModelProperty(value = "사용자 이름", example = "test", required = true)
    private String name;

    @ApiModelProperty(value = "나이", example = "10", required = true)
    private int age;

    @ApiModelProperty(value = "직업", example = "dev", required = true)
    private String job;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private List<ItemDto> items;

    public UserRequest(String name, String job, int age) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

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
