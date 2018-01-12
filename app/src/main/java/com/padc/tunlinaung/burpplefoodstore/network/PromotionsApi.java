package com.padc.tunlinaung.burpplefoodstore.network;

import com.padc.tunlinaung.burpplefoodstore.network.responses.GetFeaturesResponse;
import com.padc.tunlinaung.burpplefoodstore.network.responses.GetPromotionsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public interface PromotionsApi {

    @FormUrlEncoded
    @POST("getPromotions.php")
    Call<GetPromotionsResponse> getPromotions(@Field("access_token") String accessToken, @Field("page") int page);

}
