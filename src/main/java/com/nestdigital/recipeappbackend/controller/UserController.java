package com.nestdigital.recipeappbackend.controller;

import com.nestdigital.recipeappbackend.dao.UserDao;
import com.nestdigital.recipeappbackend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signup",consumes = "application/json",produces = "application/json")
    private String signup(@RequestBody UserModel user){
        System.out.println(user.toString());
        dao.save(user);
        return "(status:'success')";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signin",consumes = "application/json",produces = "application/json")
    public List<UserModel> signin(@RequestBody UserModel signin){
        return (List<UserModel>) dao.signin(signin.getEmail(),signin.getPassword());
    }
}
