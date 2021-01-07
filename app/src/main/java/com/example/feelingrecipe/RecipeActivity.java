package com.example.feelingrecipe;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private String title = "";
    private String url = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");

        getSupportActionBar().setTitle(title);

        setContentView(R.layout.activity_recipe);
        recyclerView = findViewById(R.id.recyclerView_chart);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        getData();


    }

    private void getData(){
        RecipeParser recipeParser = new RecipeParser(this, title, url);
        recipeParser.execute();
    }

}