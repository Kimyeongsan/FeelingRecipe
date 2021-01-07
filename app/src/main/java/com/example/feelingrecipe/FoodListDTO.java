package com.example.feelingrecipe;

public class FoodListDTO {
    private String titleStr;
    private String sub_titleStr;
    private String subUrl;
    private String iconStr;


    public FoodListDTO(String iconStr, String titleStr, String subUrl, String sub_titleStr) {
        this.iconStr = iconStr;
        this.subUrl = subUrl;
        this.titleStr = titleStr;
        this.sub_titleStr = sub_titleStr;
    }

    public String getIcon() {
        return this.iconStr;
    }
    public String getSubUrl() {
        return this.subUrl;
    }
    public String getTitleStr() {
        return this.titleStr;
    }
    public String getSub_titleStr() {
        return this.sub_titleStr;
    }

}