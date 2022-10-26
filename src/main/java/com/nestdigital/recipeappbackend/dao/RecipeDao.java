package com.nestdigital.recipeappbackend.dao;

import com.nestdigital.recipeappbackend.model.RecipeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface RecipeDao extends CrudRepository<RecipeModel,Integer> {

    @Query(value = "SELECT `id`, `category`, `date`, `description`, `recipe`, `userid` FROM `recipes` WHERE `userid`= :userid",nativeQuery = true)
    List<Map<String,String>> myRecipe(Integer userid);
}
