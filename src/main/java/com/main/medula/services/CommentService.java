package com.main.medula.services;

import com.main.medula.dtos.CommentDto;
import com.main.medula.models.CommentsModel;
import com.main.medula.models.UsersModel;
import com.main.medula.repositories.CommentsRepository;
import com.main.medula.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class CommentService {

    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    UsersRepository usersRepository;

    public CommentService(CommentsRepository repository, UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.commentsRepository = repository;
    }

    public ResponseEntity<String> saveComment(String token, CommentDto dto) {
        CommentsModel comment = dto.materialize();
        Optional<UsersModel> user = usersRepository.findByToken(token);
        if(user.isEmpty() || user.get().getId() != comment.getUser().getId()) {
            return ResponseEntity.status(401).body("Unauthorized");
        }

        commentsRepository.save(comment);
        return ResponseEntity.ok("Comment saved successfully");
    }

    public ResponseEntity<String> deleteComment(String token, int commentId) {
        Optional<CommentsModel> comment = commentsRepository.findById(commentId);
        if(comment.isEmpty()) {
            return ResponseEntity.status(404).body("Comment not found");
        }
        Optional<UsersModel> user = usersRepository.findByToken(token);
        if(user.isEmpty() || user.get().getId() != comment.get().getUser().getId()) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        commentsRepository.deleteById(commentId);
        return ResponseEntity.ok("Comment deleted successfully");
    }

    public ResponseEntity<String> updateComment(String token, int commentId, CommentDto dto) {
        Optional<CommentsModel> comment = commentsRepository.findById(commentId);
        if(comment.isEmpty()) {
            return ResponseEntity.status(404).body("Comment not found");
        }
        Optional<UsersModel> user = usersRepository.findByToken(token);
        if(user.isEmpty() || user.get().getId() != comment.get().getUser().getId()) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        CommentsModel updatedComment = dto.materialize();
        updatedComment.setId(commentId);
        commentsRepository.save(updatedComment);
        return ResponseEntity.ok("Comment updated successfully");
    }

}
