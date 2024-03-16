package com.example.jsonplaceholderapp.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post implements Serializable {

    private Integer id;
    private Integer userId;
    private String title;
    private String body;

}
