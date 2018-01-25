package com.padc.tunlinaung.burpplefoodstore.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.tunlinaung.burpplefoodstore.data.vo.FavFoodPlaceVO;
import com.padc.tunlinaung.burpplefoodstore.data.vo.FavFoodVO;
import com.padc.tunlinaung.burpplefoodstore.data.vo.LoginUserVO;

import java.util.List;

/**
 * Created by eidoshack on 1/25/18.
 */

public class RegisterResponse {

    private int code;
    private String message;
    @SerializedName("register_user")
    private LoginUserVO registerUser;
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

    public LoginUserVO getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(LoginUserVO registerUser) {
        this.registerUser = registerUser;
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
