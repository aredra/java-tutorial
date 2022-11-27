package com.example.hello.controller;

import com.example.hello.annotation.Auth;
import com.example.hello.annotation.Decode;
import com.example.hello.annotation.Timer;
import com.example.hello.dto.User;
import com.example.hello.dto.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Map;

@Slf4j
@Auth
@Validated
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

    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User userRequest) {
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

    // TODO aop
    @Timer
    @PostMapping("/aop/post")
    public User post(@Valid @RequestBody User user) throws InterruptedException {
        Thread.sleep(1000);
        return user;
    }

    // req - object mapper - object - method - object - mapper - json - response
    @Decode
    @Timer
    @PostMapping("/aop/post-dto")
    public User postUserModel(@RequestBody User userRequest) {
        return userRequest;
    }

    // TODO validation
    @PostMapping("/valid/echo")
    public ResponseEntity<?> postEcho(@Valid @RequestBody User user,
                                      BindingResult bindingResult) {

        log.debug(user.toString());

        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError fieldError = (FieldError) objectError;
                String errorMessage = objectError.getDefaultMessage();

                sb.append("Field: ").append(fieldError.getField()).append(", Message: ").append(errorMessage).append("\n");
                log.error(sb.toString());
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb);
        }

        return ResponseEntity.ok(user);
    }

    // TODO exception
    @GetMapping("/exception/get")
    public User exceptionGet(@Size(min = 1) @RequestParam String name, @Min(0) @RequestParam int age) {

        User user = new User();
        user.setName(name);
        user.setAge(age);

        return user;
    }
}
