package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping(path = "/path-variable/{message}")
    public String returnPathVariable(@PathVariable() String message) {
        return "Hi " + message;
    }

    @GetMapping("/query")
    public String returnQueryParameter(@RequestParam Map<String, String> param) {

        StringBuilder sb = new StringBuilder();

        param.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
            System.out.println("\n");

            sb.append(key).append(" : ").append(value).append("\n");
        });

        return sb.toString();
    }

    @GetMapping("/query-particle")
    public String returnQueryParameter(@RequestParam String name,
                                       @RequestParam int age,
                                       @RequestParam String job) {


        return name + ", " + age + ", " + job;
    }

    @GetMapping("/query-dto")
    public String returnQueryParameter(UserRequest userRequest) {

        return userRequest.toString();
    }

    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }

    @PostMapping("/post-dto")
    public void post(@RequestBody UserRequest userRequest) {
        System.out.println(userRequest.toString());
    }

    @PutMapping("/put")
    public UserRequest put(@RequestBody UserRequest userRequest) {
        System.out.println(userRequest.toString());
        return userRequest;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id,
                       @RequestParam(required = false) String account) {

        System.out.println(id + ", " + account);
    }
}
