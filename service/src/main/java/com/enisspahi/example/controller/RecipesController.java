package com.enisspahi.example.controller;

import com.enisspahi.example.model.Recipe;
import com.enisspahi.example.service.RecipesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Recipes API")
public class RecipesController {

    private final RecipesService recipesService;

    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @PostMapping("/recipes")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a recipe")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipesService.store(recipe);
    }

    @GetMapping("/recipes")
    @Operation(summary = "List all recipes")
    public List<Recipe> findRecipes(@RequestParam Optional<String> title,
                                    @RequestParam Optional<List<String>> ingredients,
                                    @RequestParam Optional<List<Recipe.NutritionFact>> nutritionFacts) {
        return recipesService.search(title, ingredients.orElse(Collections.emptyList()), nutritionFacts.orElse(Collections.emptyList()));
    }

}
