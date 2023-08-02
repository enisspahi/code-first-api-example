package com.enisspahi.example.codefirstapi.repository;

import com.enisspahi.example.codefirstapi.model.Recipe;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
class FakeRecipeRepository implements RecipeRepository {

    private final List<Recipe> recipes = new ArrayList();

    @Override
    public Recipe save(Recipe recipe) {
        recipes.add(recipe);
        return recipe;
    }

    @Override
    public List<Recipe> findBy(Optional<String> title, List<String> ingredients, List<Recipe.NutritionFact> nutritionFacts) {
        return recipes.stream()
                .filter(filterByTitle(title))
                .filter(filterByIngredients(ingredients))
                .filter(filterByNutritionFacts(nutritionFacts))
                .collect(Collectors.toList());
    }


    private static Predicate<Recipe> filterByTitle(Optional<String> title) {
        return recipe -> title.map(t -> recipe.title().toLowerCase().contains(t.toLowerCase())).orElse(true);
    }

    private static Predicate<Recipe> filterByIngredients(List<String> ingredients) {
        if (CollectionUtils.isEmpty(ingredients)) return recipe -> true;
        return recipe -> recipe.ingredients().stream().map(Recipe.Ingredient::name)
                .anyMatch(name -> ingredients.contains(name));
    }

    private static Predicate<Recipe> filterByNutritionFacts(List<Recipe.NutritionFact> nutritionFacts) {
        if (CollectionUtils.isEmpty(nutritionFacts)) return recipe -> true;
        return recipe -> recipe.nutritionFacts().stream().anyMatch(nutritionFacts::contains);
    }

}
