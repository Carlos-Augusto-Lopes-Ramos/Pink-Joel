package com.main.medula.services;

import com.main.medula.dtos.LoginDto;
import com.main.medula.dtos.RecoverDto;
import com.main.medula.dtos.UserDto;
import com.main.medula.models.UsersModel;
import com.main.medula.repositories.UsersRepository;
import com.main.medula.toolkit.Aleatorizador;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final UsersRepository usersRepository;
    
    private final EmailServiceImpl emailService;



    @Autowired
    public UserService(UsersRepository repository, EmailServiceImpl emailService) {
        this.usersRepository = repository;
        this.emailService = emailService;
    }

    public ResponseEntity<Object> register(UserDto dto) {

        UsersModel instance = dto.materialize();
        Optional<UsersModel> check = usersRepository.findByEmail(instance.getEmail());

        if(check.isPresent()){
            //Usuário já cadastrado
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: 1001 (Email já cadastrado)");
        }
        instance.setToken(Aleatorizador.aleatorizar(24));
        usersRepository.save(instance);
        return ResponseEntity.status(HttpStatus.OK).body(instance);
    }

    public ResponseEntity<Object> login(LoginDto dto) {
        Optional<UsersModel> instance = usersRepository.findByEmailAndPswrd(dto.email(), dto.pswrd());

        if(instance.isPresent())
        {
            instance.get().setToken(Aleatorizador.aleatorizar(24));
            usersRepository.save(instance.get());
            return ResponseEntity.status(HttpStatus.OK).body(instance);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Error: 1002 (Email ou senha incorretos)");
    }

    public ResponseEntity<Object> getUserByToken(@NotNull String token) {
        Optional<UsersModel> instance = usersRepository.findByToken(token);

        if(instance.isPresent()) {
            return  ResponseEntity.status(HttpStatus.OK).body(instance);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Error: 1003 (Token de usuário expirou ou não existe)");
    }

    public ResponseEntity<Object> passWordRecover(RecoverDto dto){
        Optional<UsersModel> instance = usersRepository.findByEmail(dto.email());
        if(instance.isPresent()) {
            String token = instance.get().getToken();
            String builder = "Que bom te ver de novo!, seu token para recuperação de senha é: " + token +
                    " \n\n" +
                    "Caso não tenha solicitado a recuperação de senha, desconsidere esse email.";
            emailService.sendEmail(instance.get().getEmail(), "Recuperação de senha", builder);
            return ResponseEntity.status(HttpStatus.OK).body("Email enviado com sucesso!");
        }
        //Usuário não encontrado
        return ResponseEntity.status(HttpStatus.OK).body("Error: 1005 (Email não encontrado)");
    }

    public ResponseEntity<Object> passWordRecover(@NotNull String token, LoginDto dto){
        Optional<UsersModel> instance = usersRepository.findByToken(token);
        if(instance.isPresent()) {
            instance.get().setPswrd(dto.pswrd());
            usersRepository.save(instance.get());
            return ResponseEntity.status(HttpStatus.OK).body(instance);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Error: 1004 (Token incorreto)");
    }
}
