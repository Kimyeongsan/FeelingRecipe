package com.example.feelingrecipe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class FoodListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FoodListAdapter adapter;
    Button buttonSearch;
    EditText editSearch;

    boolean isFilter = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodlist);
        // Adapter 생성
        adapter = new FoodListAdapter(this.getApplicationContext());


        ArrayList<String> array = getIntent().getStringArrayListExtra("result");

        if(array == null || array.isEmpty()){
            getData(adapter);
        }else{
            FoodParser foodParser = new FoodParser(adapter, this,array);
            foodParser.execute();
        }



        buttonSearch = findViewById(R.id.button_search);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editSearch.getText().toString().isEmpty()){
                    isFilter = false;
                    getData(adapter);
                }else{
                    isFilter = false;
                    adapter.clear();
                    FoodParser foodParser = new FoodParser(adapter, FoodListActivity.this, editSearch.getText().toString());
                    foodParser.execute();
                }

            }
        });
        editSearch = findViewById(R.id.editTextFilter);

        recyclerView = findViewById(R.id.foodRecyclerView);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void getData(FoodListAdapter adapter){
        System.out.println("@@@@@");
        adapter.clear();
        FoodParser foodParser = new FoodParser(adapter, this);
        foodParser.execute();
    }


    public String getSearchString(){
        return editSearch.getText().toString();
    }
}