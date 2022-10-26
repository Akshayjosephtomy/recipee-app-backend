package com.nestdigital.recipeappbackend.dao;

import com.nestdigital.recipeappbackend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phone` FROM `users` WHERE `email`= :email AND `password`= :password",nativeQuery = true)
    List<UserModel> signin(String email, String password);
}
