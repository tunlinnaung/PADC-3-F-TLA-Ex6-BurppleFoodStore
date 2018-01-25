package com.padc.tunlinaung.burpplefoodstore.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eidoshack on 1/25/18.
 */

public class FavFoodVO {

    @SerializedName("favorite_food_id")
    private int id;
    private String title;
    private String photoUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
