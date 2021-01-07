
package com.example.feelingrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class FeelingSelectActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout selectisRice, selectisHappy, selectTasty, selectHow , selectSource;
    Button selectRice, selectunRice, // 1번
            selectHappy, selectunHappy, // 2번
            tastyPalatable, tastyFresh, tastyMide, tastySweet, tastySpicy, // 3번
            howRoast, howFry, howStir_fry, howBoil, // 4번
            sourcePork, sourceChicken, sourceKimchi; // 5번
    int state = 0;

    int selectedTasty, selectedSource, selectedHow;
    boolean selectedIsRice, selectedIsHappy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeling);

        selectisRice = findViewById(R.id.select_isRice);
        selectisHappy = findViewById(R.id.select_isHappy);
        selectTasty = findViewById(R.id.select_tasty);
        selectHow = findViewById(R.id.select_how);
        selectSource = findViewById(R.id.select_source);

        selectRice = findViewById(R.id.select_Rice);
        selectunRice = findViewById(R.id.select_unRice);

        selectHappy = findViewById(R.id.select_Happy);
        selectunHappy = findViewById(R.id.select_unHappy);

        tastyPalatable = findViewById(R.id.tasty_palatable);
        tastyFresh = findViewById(R.id.tasty_fresh);
        tastyMide = findViewById(R.id.tasty_mide);
        tastySweet = findViewById(R.id.tasty_sweet);
        tastySpicy = findViewById(R.id.tasty_spicy);

        howRoast = findViewById(R.id.how_roast);
        howFry = findViewById(R.id.how_fry);
        howStir_fry = findViewById(R.id.how_stir_fry);
        howBoil = findViewById(R.id.how_boil);

        sourcePork = findViewById(R.id.source_pork);
        sourceChicken = findViewById(R.id.source_chicken);
        sourceKimchi = findViewById(R.id.source_kimchi);

        // 밥인지 아닌지 2가지
        selectRice.setOnClickListener(this);
        selectunRice.setOnClickListener(this);

        // 행복한지 아닌지 2가지
        selectHappy.setOnClickListener(this);
        selectunHappy.setOnClickListener(this);

        // ishappy 맛 3가지
        tastyPalatable.setOnClickListener(this);
        tastyFresh.setOnClickListener(this);
        tastyMide.setOnClickListener(this);

        // unhappy 맛 2가지
        tastySweet.setOnClickListener(this);
        tastySpicy.setOnClickListener(this);

        // 요리 방법 4가지
        howRoast.setOnClickListener(this);
        howFry.setOnClickListener(this);
        howStir_fry.setOnClickListener(this);
        howBoil.setOnClickListener(this);

        // 소스 3가지
        sourcePork.setOnClickListener(this);
        sourceChicken.setOnClickListener(this);
        sourceKimchi.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (state == 0) {
            state = 1;
        } else if (state == 1) {
            state = 2;
        } else if (state == 2) {
            state = 3;
        } else if (state == 3) {
            state = 4;
        }else{
            state = 5;
        }

        if(state == 1) {
            selectisRice.setVisibility(View.GONE);
            selectisHappy.setVisibility(View.VISIBLE);
            selectTasty.setVisibility(View.GONE);
            selectHow.setVisibility(View.GONE);
            selectSource.setVisibility(View.GONE);
        }
        if(state == 2) {
            selectisRice.setVisibility(View.GONE);
            selectisHappy.setVisibility(View.GONE);
            selectTasty.setVisibility(View.VISIBLE);
            selectHow.setVisibility(View.GONE);
            selectSource.setVisibility(View.GONE);
        }
        if(state == 3) {
            selectisRice.setVisibility(View.GONE);
            selectisHappy.setVisibility(View.GONE);
            selectTasty.setVisibility(View.GONE);
            selectHow.setVisibility(View.VISIBLE);
            selectSource.setVisibility(View.GONE);
        }
        if(state == 4) {
            selectisRice.setVisibility(View.GONE);
            selectisHappy.setVisibility(View.GONE);
            selectTasty.setVisibility(View.GONE);
            selectHow.setVisibility(View.GONE);
            selectSource.setVisibility(View.VISIBLE);

            System.out.println(selectedTasty + " : " + selectedSource + " : "+ selectedHow);


        }
        if(state == 5){
            Intent intent = new Intent(FeelingSelectActivity.this, FeelingResultActivity.class);
            intent.putExtra("tasty",selectedTasty);
            intent.putExtra("source",selectedSource);
            intent.putExtra("how",selectedHow);
            intent.putExtra("isRice",selectedIsRice);
            intent.putExtra("isHappy",selectedIsHappy);
            startActivity(intent);
            finish();
        }


        switch(view.getId()){
            case R.id.tasty_sweet:
                selectedTasty = FeelingFood.TASTY_SWEET;
                break;
            case R.id.tasty_fresh:
                selectedTasty = FeelingFood.TASTY_FRESH;
                break;
            case R.id.tasty_mide:
                selectedTasty = FeelingFood.TASTY_MIDE;
                break;
            case R.id.tasty_palatable:
                selectedTasty = FeelingFood.TASTY_PALATABLE;
                break;
            case R.id.tasty_spicy:
                selectedTasty = FeelingFood.TASTY_SPICY;
                break;
            case R.id.source_chicken:
                selectedSource = FeelingFood.SOURCE_CHICKEN;
                break;
            case R.id.source_pork:
                selectedSource = FeelingFood.SOURCE_PORK;
                break;
            case R.id.source_kimchi:
                selectedSource = FeelingFood.SOURCE_KiMCHI;
                break;
            case R.id.how_boil:
                selectedHow = FeelingFood.HOW_BOIL;
                break;
            case R.id.how_fry:
                selectedHow = FeelingFood.HOW_FRY;
                break;
            case R.id.how_roast:
                selectedHow = FeelingFood.HOW_ROAST;
                break;
            case R.id.how_stir_fry:
                selectedHow = FeelingFood.HOW_STIR_FRY;
                break;
            case R.id.select_Rice:
                selectedIsRice = true;
                break;
            case R.id.select_unRice:
                selectedIsRice = false;
                break;
            case R.id.select_Happy:
                selectedIsHappy = true;
                break;
            case R.id.select_unHappy:
                selectedIsHappy = false;
                break;
        }
    }
}
