package com.main.medula.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="users")
public class UsersModel {

    public UsersModel() {};

    public UsersModel(String email, String name, String pswrd, boolean master)
    {
        this.email = email;
        this.name = name;
        this.pswrd = pswrd;
        this.master = master;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;


    @OneToMany
    @JoinColumn(name="id_user")
    private List<CommentsModel> comments;



    private String email;

    private String pswrd;

    private String token;

    private boolean master;


}
