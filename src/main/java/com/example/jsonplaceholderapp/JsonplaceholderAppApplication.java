package com.example.jsonplaceholderapp;

import com.example.jsonplaceholderapp.service.FetchPostsService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@AllArgsConstructor
public class JsonplaceholderAppApplication {


    FetchPostsService fetchPostsService;


    public static void main(String[] args) {
        SpringApplication.run(JsonplaceholderAppApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        fetchPostsService.fetchData();
    }
}
