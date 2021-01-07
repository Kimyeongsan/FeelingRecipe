package com.example.feelingrecipe;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private RecipeDTO data;
    private View view;
    RecyclerAdapter(RecipeDTO recipeDTO){
        this.data = recipeDTO;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recipe, viewGroup, false);
        return new
                ItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.onBind(data.recipes.get(i));
    }
    @Override
    public int getItemCount() {
        return data.recipes.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_chart;
        private TextView recipe_txt, source_txt;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            img_chart  = itemView.findViewById(R.id.img_chart);
            recipe_txt = itemView.findViewById(R.id.txt_chartName);
            source_txt = itemView.findViewById(R.id.txt_source);
        }

        void onBind(Recipe data) {
            recipe_txt.setText(data.getTxtUrl());
            source_txt.setText(data.getSucUrl());
            Glide.with(itemView.getContext()).asBitmap().load(data.getimgUrl()).
                    into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition){
                            img_chart.setImageBitmap(resource);
                        }
                    });

        }
    }
}
