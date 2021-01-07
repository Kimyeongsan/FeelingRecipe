package com.example.feelingrecipe;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class RecipeParser extends AsyncTask<Void, Void, Void> {
    private RecipeActivity activity;
    private String url;
    private String title;


    public RecipeParser(RecipeActivity activity, String title ,String url) {
        this.activity = activity;
        this.url = url;
        this.title = title;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Document doc = Jsoup.connect(url).get();
            final String list_decStr = doc.select("#modal-content > div > div.view_recipe > section.sec_info > div > div.btm > ul > p").text();
            final RecipeDTO recipeDTO = new RecipeDTO(title,list_decStr);

            for (int i = 1; i <= 20; i++) {
                final String list_recipe = doc.select("#container > div.inpage-recipe > div > div.view_recipe > section.sec_detail > section.sec_rcp_step > ol > li:nth-child(" + i + ") > p").text();
                final String list_imageUrl = doc.select("#container > div.inpage-recipe > div > div.view_recipe > section.sec_detail > section.sec_rcp_step > ol > li:nth-child(" + i + ") > div > img").attr("src");
                if(!list_recipe.isEmpty())
                    recipeDTO.addRecipe(new Recipe(list_recipe, list_imageUrl, list_decStr));
            }

            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    activity.recyclerView.setAdapter(new RecyclerAdapter(recipeDTO));

                }
            });
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
