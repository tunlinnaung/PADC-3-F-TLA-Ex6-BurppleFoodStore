package com.padc.tunlinaung.burpplefoodstore.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class PromotionsVO {

    @SerializedName("burpple-promotion-id")
    private String id;
    @SerializedName("burpple-promotion-image")
    private String image;
    @SerializedName("burpple-promotion-title")
    private String title;
    @SerializedName("burpple-promotion-until")
    private String untilTime;
    @SerializedName("burpple-promotion-shop")
    private ShopVO shopVo;
    @SerializedName("is-burpple-exclusive")
    private boolean isExclusive;
    @SerializedName("burpple-promotion-terms")
    private List<String> terms;

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getUntilTime() {
        return untilTime;
    }

    public ShopVO getShopVo() {
        return shopVo;
    }

    public boolean isExclusive() {
        return isExclusive;
    }

    public List<String> getTerms() {
        return terms;
    }
}
