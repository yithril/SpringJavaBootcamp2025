package com.example.spring_demo.controllers;

import com.example.spring_demo.models.Recipe;
import com.example.spring_demo.repository.RecipeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipe")
@CrossOrigin(origins = "*")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    // Get all recipes
    @GetMapping
    public List<Recipe> getAllRecipes(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String ingredients
    ) {
        if (name != null && ingredients != null) {
            return recipeRepository.findByNameContainingAndIngredientsContaining(name, ingredients);
        } else if (name != null) {
            return recipeRepository.findByNameContaining(name);
        } else if (ingredients != null) {
            return recipeRepository.findByIngredientsContaining(ingredients);
        } else {
            return recipeRepository.findAll();
        }
    }

    // Get recipe by ID
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isPresent()) {
            return ResponseEntity.ok(recipe.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new recipe
    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody @Valid Recipe recipe) {
        Recipe savedRecipe = recipeRepository.save(recipe);
        return ResponseEntity.status(201).body(savedRecipe);
    }

    // Update a recipe
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody @Valid Recipe recipeDetails) {
        Optional<Recipe> existingRecipe = recipeRepository.findById(id);
        if (existingRecipe.isPresent()) {
            Recipe recipe = existingRecipe.get();
            recipe.setName(recipeDetails.getName());
            recipe.setIngredients(recipeDetails.getIngredients());
            recipe.setInstructions(recipeDetails.getInstructions());
            Recipe updatedRecipe = recipeRepository.save(recipe);
            return ResponseEntity.ok(updatedRecipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a recipe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        Optional<Recipe> existingRecipe = recipeRepository.findById(id);
        if (existingRecipe.isPresent()) {
            recipeRepository.delete(existingRecipe.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
