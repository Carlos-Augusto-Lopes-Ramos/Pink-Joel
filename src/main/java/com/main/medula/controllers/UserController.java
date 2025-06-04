package com.main.medula.controllers;

import com.main.medula.dtos.LoginDto;
import com.main.medula.dtos.RecoverDto;
import com.main.medula.dtos.UserDto;
import com.main.medula.repositories.UsersRepository;
import com.main.medula.services.EmailServiceImpl;
import com.main.medula.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    UsersRepository userRepository;


    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    UserService commando = new UserService(userRepository, emailService);

    //User Controller Area
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Object> createNewUser(@RequestBody UserDto dto) {

        return commando.register(dto);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Object> getUser(@RequestBody LoginDto dto) {
        return commando.login(dto);
    }

    @PostMapping("/login/{token}")
    @ResponseBody
    public ResponseEntity<Object> getUserByToken(@PathVariable("token") String token) {
        return commando.getUserByToken(token);
    }

    @PostMapping("/login/recover")
    @ResponseBody
    public ResponseEntity<Object> updatePswrd(@RequestBody RecoverDto dto) {
        return commando.passWordRecover(dto);
    }

    @PostMapping("/login/recover/{token}")
    @ResponseBody
    public ResponseEntity<Object> updatePswrd(@RequestBody LoginDto dto, @PathVariable("token") String token) {
        return commando.passWordRecover(token, dto);
    }


}
