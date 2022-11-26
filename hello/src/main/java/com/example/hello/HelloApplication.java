package com.example.hello;

import com.example.hello.controller.ApiController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();

        ApiController apiController = context.getBean(ApiController.class);
    }

}


@Configuration
class AppConfig {

}