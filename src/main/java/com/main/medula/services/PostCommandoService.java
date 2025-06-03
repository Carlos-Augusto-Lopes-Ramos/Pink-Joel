package com.main.medula.services;

import com.main.medula.dtos.PostDto;
import com.main.medula.models.CommentsModel;
import com.main.medula.models.PostsModel;
import com.main.medula.repositories.CommentsRepository;
import com.main.medula.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@Service
public class PostCommandoService {

    @Autowired
    PostsRepository postsRepository;
    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    public PostCommandoService(PostsRepository post, CommentsRepository comments) {
        this.postsRepository = post;
        this.commentsRepository = comments;
    };


    public PostCommandoService(PostsRepository post) {
        this.postsRepository = post;
    };



    public ResponseEntity<Object> getAllPosts() {
        List<PostsModel> postsList = postsRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(postsList);
    };

    public ResponseEntity<Object> postCreation(PostDto dto)
    {
        PostsModel instance = dto.materialize();
        postsRepository.save(instance);
        return ResponseEntity.status(HttpStatus.OK).body(instance);
    };

    public ResponseEntity<String> deletePost(int id){
        Optional<PostsModel> postToDelete = postsRepository.findById(id);
        if(postToDelete.isPresent()){
            if(!postToDelete.get().getComments().isEmpty()){
                List<CommentsModel> comments = postToDelete.get().getComments();
                for (CommentsModel comment : comments) {
                    commentsRepository.deleteById(comment.getId());
                }
            };
            postsRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        };
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    };



    public ResponseEntity<Object> getHighLights (int pageNo) {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PostsModel> postsList = postsRepository.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(postsList);
    };


}
