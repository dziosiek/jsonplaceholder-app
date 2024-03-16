package com.example.jsonplaceholderapp.util;

import com.example.jsonplaceholderapp.model.Post;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class DataToJsonFileWritter {

    private static final String RESOURCES_PATH_POSTS = "src/main/resources/data/posts";

    public void writePostToFile(Post post) {

        Gson gson = new Gson();

        try {
            FileWriter fw =
                new FileWriter(RESOURCES_PATH_POSTS + "/" + post.getId().toString() + ".json");
            gson.toJson(post, fw);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
