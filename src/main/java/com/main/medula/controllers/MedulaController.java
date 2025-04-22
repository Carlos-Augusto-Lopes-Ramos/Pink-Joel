package com.main.medula.controllers;

import com.main.medula.dtos.LoginDto;
import com.main.medula.dtos.PostDto;
import com.main.medula.dtos.RecoverDto;
import com.main.medula.dtos.UserDto;
import com.main.medula.repositories.PostsRepository;
import com.main.medula.repositories.UsersRepository;
import com.main.medula.services.EmailServiceImpl;
import com.main.medula.services.PostCommandoService;
import com.main.medula.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class MedulaController {

    @GetMapping
    @ResponseBody
    public ResponseEntity<Object> helloWorld() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello World!");
    }

}
