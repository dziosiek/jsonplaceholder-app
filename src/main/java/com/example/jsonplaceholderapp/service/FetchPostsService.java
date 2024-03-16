package com.example.jsonplaceholderapp.service;


import com.example.jsonplaceholderapp.model.Post;
import com.example.jsonplaceholderapp.util.DataToJsonFileWritter;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class FetchPostsService {

    private static final Logger logger = LogManager.getLogger();
    private static final String API_URL = "https://jsonplaceholder.typicode.com";
    private final DataToJsonFileWritter dataToJsonFileWritter;

    public void fetchData() {

        logger.info("Start fetching data..");

        WebClient client = WebClient.create(API_URL + "/posts");
        Post[] posts = client.get().retrieve().bodyToMono(Post[].class)
            .block();

        Arrays.asList(posts).forEach(dataToJsonFileWritter::writePostToFile);

        logger.info("Data fetching done. Saved " + posts.length + " files");
    }
}
