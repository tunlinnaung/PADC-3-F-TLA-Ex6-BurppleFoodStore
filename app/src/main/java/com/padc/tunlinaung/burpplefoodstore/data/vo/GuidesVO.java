package com.padc.tunlinaung.burpplefoodstore.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class GuidesVO {

    @SerializedName("burpple-guide-id")
    private String id;
    @SerializedName("burpple-guide-image")
    private String image;
    @SerializedName("burpple-guide-title")
    private String title;
    @SerializedName("burpple-guide-desc")
    private String description;

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

}
