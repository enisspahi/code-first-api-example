package com.enisspahi.example.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record Recipe(@Schema(description = "Title of the recipe", example = "Chilli sin Carne")
                     String title,
                     @Schema(description = "List of ingredients")
                     List<Ingredient> ingredients,
                     @Schema(description = "Preparation time (in minutes)", example = "30")
                     Integer preparationTime,
                     @Schema(description = "Cooking time (in minutes)", example = "15")
                     Integer cookingTime,
                     @Schema(description = "Served for persons", example = "4")
                     Integer servings,
                     @Schema(description = "Step by step instructions")
                     List<String> instructions,
                     @Schema(description = "Nutrition facts")
                     List<NutritionFact> nutritionFacts) {

    public record Ingredient(@Schema(description = "Name of the ingredient", example = "Kidney beans")
                      String name,
                      @Schema(description = "Quantity depending on unit", example = "250")
                      Double quantity,
                      @Schema(description = "Quantifying unit of the ingredient (grams, milliliters, count, tablespoon)", example = "grams")
                      String unit) {
    }

    public enum NutritionFact { LOW_CALORIE, HIGH_CALORIE, HIGH_PROTEIN, CARBS }

}


