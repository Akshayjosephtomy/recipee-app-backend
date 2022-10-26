package com.nestdigital.recipeappbackend.controller;

import com.nestdigital.recipeappbackend.dao.RecipeDao;
import com.nestdigital.recipeappbackend.model.RecipeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class RecipeController {

    @Autowired
    private RecipeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addrecipe",consumes = "application/json",produces = "application/json")
    private String addRecipe(@RequestBody RecipeModel recipe){
        DateTimeFormatter dt= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now= LocalDateTime.now();
        String currentdate= String.valueOf(dt.format(now));
        recipe.setDate(currentdate);
        System.out.println(recipe.toString());
        dao.save(recipe);
        return "(status:'success')";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/myrecipe",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> myRecipe(@RequestBody RecipeModel recipe){
        return (List<Map<String,String>>)dao.myRecipe(recipe.getUserid());
    }


}
