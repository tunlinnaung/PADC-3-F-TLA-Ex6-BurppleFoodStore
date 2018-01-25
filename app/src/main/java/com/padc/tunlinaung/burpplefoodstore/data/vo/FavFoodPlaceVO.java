package com.padc.tunlinaung.burpplefoodstore.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eidoshack on 1/25/18.
 */

public class FavFoodPlaceVO {

    @SerializedName("favorite_food_place_id")
    private int id;
    private String title;
    private String address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
