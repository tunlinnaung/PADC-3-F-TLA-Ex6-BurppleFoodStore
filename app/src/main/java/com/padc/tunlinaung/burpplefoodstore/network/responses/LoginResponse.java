package com.padc.tunlinaung.burpplefoodstore.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.tunlinaung.burpplefoodstore.data.vo.FavFoodPlaceVO;
import com.padc.tunlinaung.burpplefoodstore.data.vo.FavFoodVO;
import com.padc.tunlinaung.burpplefoodstore.data.vo.LoginUserVO;

import java.util.List;

/**
 * Created by eidoshack on 1/25/18.
 */

public class LoginResponse {

    private int code;
    private String message;
    @SerializedName("login_user")
    private LoginUserVO loginUser;
    @SerializedName("fav_foods")
    private List<FavFoodVO> favFoods;
    @SerializedName("fav_food_places")
    private List<FavFoodPlaceVO> favFoodPlaces;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginUserVO getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUserVO loginUser) {
        this.loginUser = loginUser;
    }

    public List<FavFoodVO> getFavFoods() {
        return favFoods;
    }

    public void setFavFoods(List<FavFoodVO> favFoods) {
        this.favFoods = favFoods;
    }

    public List<FavFoodPlaceVO> getFavFoodPlaces() {
        return favFoodPlaces;
    }

    public void setFavFoodPlaces(List<FavFoodPlaceVO> favFoodPlaces) {
        this.favFoodPlaces = favFoodPlaces;
    }
}
