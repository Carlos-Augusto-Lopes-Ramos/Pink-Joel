package com.main.medula.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="posts")
public class PostsModel {

    public PostsModel(){};

    public PostsModel(String title, String content, String image) {
        this.title = title;
        this.content = content;
        this.image = image;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    @OneToMany
    @JoinColumn(name="id_post")
    private List<CommentsModel> comments;

    private String image;

    private String content;


}
