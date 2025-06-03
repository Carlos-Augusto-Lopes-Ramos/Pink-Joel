package com.main.medula.repositories;

import com.main.medula.models.CommentsModel;
import com.main.medula.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsModel, Integer> {
}
