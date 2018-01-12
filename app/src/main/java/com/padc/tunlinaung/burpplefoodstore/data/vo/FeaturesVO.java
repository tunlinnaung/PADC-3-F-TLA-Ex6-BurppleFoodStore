package com.padc.tunlinaung.burpplefoodstore.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class FeaturesVO {

    @SerializedName("burpple-featured-id")
    private String id;
    @SerializedName("burpple-featured-image")
    private String image;
    @SerializedName("burpple-featured-title")
    private String title;
    @SerializedName("burpple-featured-desc")
    private String description;
    @SerializedName("burpple-featured-tag")
    private String tag;

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTag() {
        return tag;
    }
}
