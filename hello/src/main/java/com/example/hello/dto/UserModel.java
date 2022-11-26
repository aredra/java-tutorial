package com.example.hello.dto;

import com.example.hello.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserModel {

    @NotBlank
    private String name;

    @Min(0)
    private int age;

    @Email
    private String email;

    @NotNull
    private String job;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "양식에 맞지 않습니다.")
    private String phoneNumber;

    @YearMonth
    private String yearMonth;

    @Valid
    private List<Car> cars;

    /*
    @AssertTrue(message = "yyyyMM 의 양식을 맞춰주세요.")
    public boolean isYearMonth() {

        try {
            LocalDate.parse(getYearMonth() + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    */
}
