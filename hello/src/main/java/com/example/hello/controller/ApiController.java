package com.example.hello.controller;

import com.example.hello.annotation.Auth;
import com.example.hello.annotation.Decode;
import com.example.hello.annotation.Timer;
import com.example.hello.dto.User;
import com.example.hello.dto.UserRequest;
import com.example.hello.service.AsyncService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
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
import java.util.concurrent.CompletableFuture;

@Slf4j
@Auth
@Validated
@RestController
@Api(tags = "기타 API 모음")
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final AsyncService asyncService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/plus/{x}")
    public int plus(@ApiParam(value = "엑스 값") @PathVariable int x,
                    @ApiParam(value = "와이 값") @RequestParam int y) {
        return x + y;
    }

    @ApiOperation(value = "사용자를 에코")
    @ApiResponse(code = 500, message = "사용자 정보가 이상하다.")
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

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "사용자 이름"),
            @ApiImplicitParam(name = "age", value = "사용자 나이"),
            @ApiImplicitParam(name = "job", value = "사용자 직업")
    })
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
    @ApiOperation(value = "Post 에코")
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

    @GetMapping("/async/hello")
    public CompletableFuture asyncHello() {
        log.info("Method end");
        return asyncService.run();
    }
}
