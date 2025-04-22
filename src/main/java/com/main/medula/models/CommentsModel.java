package com.main.medula.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="comments")
public class CommentsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="id_user")
    private UsersModel user;

    @ManyToOne
    @JoinColumn(name="id_post")
    private PostsModel post;

    private String image;

    private String content;

}
