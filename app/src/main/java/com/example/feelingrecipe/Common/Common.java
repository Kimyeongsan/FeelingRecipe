package com.example.feelingrecipe.Common;

import com.example.feelingrecipe.FeelingFood;

import java.util.ArrayList;

public class Common {
    public static String recipes[] = {
            "김치볶음밥", "비빔밥",  "고등어조림", "잔치국수", "잡채밥", "제육볶음", "냉면", "오므라이스",
    };

    public static String recipe_chart_url = "http://haemukja.com/recipes?utf8=%E2%9C%93&sort=rlv&name=";
    public static String recipe_url = "http://haemukja.com";

    public String[] getRecipes(ArrayList<FeelingFood> foods){
        String[] recipes = new String[foods.size()];
        int i = 0;
        for(FeelingFood food : foods){
            recipes[i] = food.name;
        }
        return recipes;
    }
}
