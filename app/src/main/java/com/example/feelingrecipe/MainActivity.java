package com.example.feelingrecipe;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.text.SimpleDateFormat;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        TextView time = findViewById(R.id.text_time);

        Long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd EEE");

        String getTime = sdf.format(date);

        time.setText("Today"+getTime);

        Button q=findViewById(R.id.Feelingbutton);
        q.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        Intent intent=new Intent(getApplicationContext(), FeelingSelectActivity.class);
                        startActivity(intent);
                    }
                }
        );

        Button infoButton=findViewById(R.id.informbutton);
        infoButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        Intent intent=new Intent(getApplicationContext(), FoodListActivity.class);
                        startActivity(intent);
                    }
                }
        );

        Button calendarButton=findViewById(R.id.calendarbutton);
        calendarButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        Intent intent=new Intent(getApplicationContext(), CalendarActivity.class);
                        startActivity(intent);
                    }
                }
        );

        Button mybutton =findViewById(R.id.myrbutton);
        mybutton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        Intent intent=new Intent(getApplicationContext(), MyRecipeDemo.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
