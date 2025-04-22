package com.main.medula.repositories;

import com.main.medula.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Integer> {
    Optional<UsersModel> findByEmailAndPswrd(String email, String pswrd);
    Optional<UsersModel> findByEmail(String email);
    Optional<UsersModel> findByToken(String token);
}
