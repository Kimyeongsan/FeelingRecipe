package com.example.feelingrecipe;

class Recipe{
    public Recipe(String txt, String img, String suc){
        this.img = img;
        this.txt = txt;
        this.suc = suc;
    }
    String img;
    String txt;
    String suc;

    String getimgUrl(){
        return img;
    }
    String getTxtUrl(){ return txt; }
    String getSucUrl() { return suc; }
}