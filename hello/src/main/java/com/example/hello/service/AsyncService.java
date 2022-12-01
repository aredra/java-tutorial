package com.example.hello.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncService {

    @Async("async-thread")
    public CompletableFuture run() {
        return new AsyncResult(hello()).completable();
    }

    public String hello() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                log.info("Thread sleep...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Async hello";
    }
}
