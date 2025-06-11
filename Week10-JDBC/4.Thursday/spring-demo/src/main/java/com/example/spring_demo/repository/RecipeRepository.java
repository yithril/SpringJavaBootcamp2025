package com.example.spring_demo.repository;

import com.example.spring_demo.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByNameContaining(String name);

    List<Recipe> findByIngredientsContaining(String ingredients);

    List<Recipe> findByNameContainingAndIngredientsContaining(String name, String ingredients);
}
