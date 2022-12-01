package com.example.hello.controller;

import com.example.hello.dto.Rep;
import com.example.hello.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);

        log.info("Server {} {}", name, age);

        return user;
    }

    @PostMapping("/user/{userId}/name/{userName}")
    public User post(@PathVariable String userId,
                     @PathVariable String userName,
                     @RequestBody User user) {

        log.info("Client req : {}, {}, {}", userId, userName, user);
        user.setName(userName);

        return user;
    }

    @PostMapping("/user/{userId}/header")
    public User headerTest(@RequestHeader("x-authorization") String authorization,
                           @RequestHeader("custom-header") String custom,
                           @PathVariable String userId,
                           @RequestBody User user) {

        log.info("Client req : {}, {}, {}", authorization, custom, user);

        return user;
    }

    @PostMapping("/user/{userId}/irregular")
    public Rep<User> irregular(
                               @RequestHeader("x-authorization") String authorization,
                               @RequestHeader("custom-header") String custom,
                               @PathVariable String userId,
                               @RequestBody Rep<User> user) {

//        TODO 요청이 보내졌을 때 에러가 나면 HttpEntity 로 디버그를 해볼 수 있다.
//        TODO 사용하면 응답을 바디를 이미 읽어서 후에 있는 RequestBody 같은 곳에서 값을 못 읽어서 에러가 난다.
//        HttpEntity<String> entity,
//        log.info("HttpEntity : {}", entity.getBody());
        log.info("Client req : {}, {}, {}", authorization, custom, user);

        Rep<User> response = new Rep<>();
        response.setHeader(new Rep.Header());
        response.setBody(user.getBody());

        return response;
    }
}
