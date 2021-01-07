package com.example.feelingrecipe;

import android.os.AsyncTask;

import com.example.feelingrecipe.Common.Common;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class FoodParser extends AsyncTask<Void, Void, Void> {
    private FoodListAdapter adapter;
    private FoodListActivity activity;

    private String[] recipes;

    public FoodParser(FoodListAdapter adapter, FoodListActivity activity){
        this.adapter = adapter;
        this.activity = activity;
        this.recipes = Common.recipes;
    }

    public FoodParser(FoodListAdapter adapter, FoodListActivity activity, ArrayList<String> recipe){
        this.adapter = adapter;
        this.activity = activity;
        this.recipes = recipe.toArray(new String[recipe.size()]);
    }

    public FoodParser(FoodListAdapter adapter, FoodListActivity activity, String recipe){
        this.adapter = adapter;
        this.activity = activity;
        this.recipes = new String[1];
        recipes[0] = recipe;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            for(String recipe : recipes) {
                Document doc = Jsoup.connect(Common.recipe_chart_url + recipe).get();
                final String list_titleStr = recipe;

                final String list_iconStr = doc.select("#content > section > div.recipes > div > ul > li:nth-child(1) > a  > img").attr("src");

                final String list_sub_url = doc.select("#content > section > div.recipes > div > ul > li:nth-child(1) > p > a").attr("href");

                final String list_sub_titleStr = doc.select("#content > section > div.recipes > div > ul > li:nth-child(1) > p").text();

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(activity.isFilter){
                            if(list_titleStr.contains(activity.getSearchString())){
                                adapter.addItem(new FoodListDTO(list_iconStr, list_titleStr, Common.recipe_url + list_sub_url, list_sub_titleStr));
                                adapter.notifyDataSetChanged();
                            }
                        }else{
                            adapter.addItem(new FoodListDTO(list_iconStr, list_titleStr, Common.recipe_url + list_sub_url, list_sub_titleStr));
                            adapter.notifyDataSetChanged();
                        }

                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
