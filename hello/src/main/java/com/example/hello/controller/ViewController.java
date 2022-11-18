package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {

    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    @ResponseBody
    @GetMapping("/user")
    public UserRequest user() {
        var user = new UserRequest();
        user.setName("test");
        user.setAge(999);
        return user;
    }
}
