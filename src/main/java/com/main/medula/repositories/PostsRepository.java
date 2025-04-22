package com.main.medula.repositories;

import com.main.medula.models.PostsModel;
import com.main.medula.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<PostsModel, Integer> {
}
