package com.example.feelingrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Set;


public class FeelingResultActivity extends AppCompatActivity {
    int selectedTasty, selectedSource, selectedHow;
    boolean selectedIsRice, selectedIsHappy;

    ArrayList<String> results;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeling_result);

        results = new ArrayList<>();
        result = findViewById(R.id.text_feeling_result);


        Intent intent = getIntent();
        selectedTasty = intent.getIntExtra("tasty",-1);
        selectedSource = intent.getIntExtra("source",-1);
        selectedHow = intent.getIntExtra("how",-1);
        selectedIsRice = intent.getBooleanExtra("isRice",false);
        selectedIsHappy = intent.getBooleanExtra("isHappy",false);

        Set<String> selectResult = FeelingFood.setHashSet(selectedTasty,selectedSource,selectedHow);
        System.out.println(selectedTasty+":"+selectedSource+":"+selectedHow);

        Object[] string = selectResult.toArray();

        ArrayList<FeelingFood> selectedFood = new ArrayList<>();
        ArrayList<FeelingFood> allFood = FeelingFood.initFoodList();

        System.out.println(selectResult);

        int i = 0;
        while(i < string.length){
            for(FeelingFood food : allFood){
                if(food.name.equals(string[i])){
                    if(food.isHappy == selectedIsHappy && food.isRice == selectedIsRice){
                        selectedFood.add(food);
                    }
                }
            }
            i ++;
        }

        String temp = "";
        for(FeelingFood f : selectedFood){
            temp = temp + f.name + "\n" ;
            results.add(f.name);
        }

        Button selectButton_Recipe=findViewById(R.id.selectButton_Recipe);
        selectButton_Recipe.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        Intent intent=new Intent(getApplicationContext(), FoodListActivity.class);
                        intent.putExtra("result",results);
                        startActivity(intent);
                    }
                }
        );

        Button selectButton_Main=findViewById(R.id.selectButton_Main);
        selectButton_Main.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
        );
        result.setText(temp);
    }

}