package com.main.medula.controllers;

import com.main.medula.dtos.PostDto;
import com.main.medula.repositories.PostsRepository;
import com.main.medula.services.PostCommandoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
@RestController
public class PostsController {

    @Autowired
    PostsRepository postsRepository;

    PostCommandoService commando = new PostCommandoService(postsRepository);

    //Posts Controller Area
    @PostMapping("/posts/create")
    @ResponseBody
    public ResponseEntity<Object> createNewPost(@RequestBody PostDto dto) {
        return commando.postCreation(dto);
    }

    @GetMapping("/posts")
    @ResponseBody
    public ResponseEntity<Object> getAllPosts() {
        return commando.getAllPosts();
    }

    @GetMapping("/posts/{page}")
    @ResponseBody
    public ResponseEntity<Object> getPostsByPage(@PathVariable("page") int page) {
        return commando.getHighLights(page);
    }

    @DeleteMapping("/posts/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deletePost(@PathVariable("id") int id) {
        return commando.deletePost(id);
    }

}
