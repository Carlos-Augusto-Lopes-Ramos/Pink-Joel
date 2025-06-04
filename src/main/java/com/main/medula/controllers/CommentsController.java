package com.main.medula.controllers;

import com.main.medula.dtos.CommentDto;
import com.main.medula.repositories.CommentsRepository;
import com.main.medula.repositories.UsersRepository;
import com.main.medula.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
@RestController
public class CommentsController {

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    CommentService commentService = new CommentService(commentsRepository, usersRepository);

    @PostMapping("/create/{token}")
    public ResponseEntity<String> createComment(@PathVariable("token") String token, CommentDto dto) {
        return commentService.saveComment(token, dto);
    }

    @DeleteMapping("/update/{token}/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") int commentId, @PathVariable("token") String token) {
        return commentService.deleteComment(token, commentId);
    }

    @PostMapping("/update/{token}/{id}")
    public ResponseEntity<String> updateComment(@PathVariable("id") int commentId, @PathVariable("token") String token, CommentDto dto) {
        return commentService.updateComment(token, commentId, dto);
    }

}
