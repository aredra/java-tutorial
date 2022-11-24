package com.example.hello.controller;

import com.example.hello.annotation.Decode;
import com.example.hello.annotation.Timer;
import com.example.hello.dto.UserModel;
import com.example.hello.dto.UserRequest;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/json")
    public UserRequest json(UserRequest userRequest) {
        return userRequest;
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

    // req - object mapper - object - method - object - mapper - json - response
    @Decode
    @Timer
    @PostMapping("/post-dto")
    public UserModel postUserModel(@RequestBody UserModel userRequest) {
        return userRequest;
    }

    @PutMapping("/put")
    public ResponseEntity<UserModel> put(@RequestBody UserModel userRequest) {
        System.out.println(userRequest.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id,
                       @RequestParam(required = false) String account) {

        System.out.println(id + ", " + account);
    }
    
    @GetMapping("/aop/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {

        return id + " : " + name;
    }

    @Timer
    @PostMapping("/aop/post")
    public UserModel post(@RequestBody UserModel user) throws InterruptedException {
        Thread.sleep(1000);
        return user;
    }
}
