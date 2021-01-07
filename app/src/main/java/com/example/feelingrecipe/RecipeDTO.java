package com.example.feelingrecipe;

import java.util.ArrayList;

public class RecipeDTO {
    private String title;
    private String source;

    public ArrayList<Recipe> recipes;

    public RecipeDTO(String title, String source) {
        this.title = title;
        this.source = source;
        recipes = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getSourse() {
        return source;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
}
