package com.padc.tunlinaung.burpplefoodstore.network;

import com.padc.tunlinaung.burpplefoodstore.network.responses.GetFeaturesResponse;
import com.padc.tunlinaung.burpplefoodstore.network.responses.LoginResponse;
import com.padc.tunlinaung.burpplefoodstore.network.responses.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by eidoshack on 1/25/18.
 */

public interface LoginApi {

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> loginUser(@Field("phoneNo") String phoneNo, @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<RegisterResponse> registerUser(@Field("phoneNo") String phoneNo, @Field("password") String password, @Field("name") String name);

}
