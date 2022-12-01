package com.example.hello;

import com.example.hello.controller.ApiController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;

@SpringBootApplication
@ServletComponentScan
@EnableAsync
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);

        ApplicationContext context = ApplicationContextProvider.getContext();

        ApiController apiController = context.getBean(ApiController.class);

        String[] beanNames = context.getBeanDefinitionNames();

        System.out.println(">>>>>>>>>>>>>> Beans start");
        Arrays.stream(beanNames).forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>> Beans end");
    }
}