package com.padc.tunlinaung.burpplefoodstore.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class ShopVO {

    @SerializedName("burpple-shop-id")
    private String id;
    @SerializedName("burpple-shop-name")
    private String name;
    @SerializedName("burpple-shop-area")
    private String ares;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAres() {
        return ares;
    }
}
