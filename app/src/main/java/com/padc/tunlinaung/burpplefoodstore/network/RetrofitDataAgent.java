package com.padc.tunlinaung.burpplefoodstore.network;

import com.google.gson.Gson;
import com.padc.tunlinaung.burpplefoodstore.events.LoadedFeaturesEvent;
import com.padc.tunlinaung.burpplefoodstore.events.LoadedGuidesEvent;
import com.padc.tunlinaung.burpplefoodstore.events.LoadedPromotionsEvent;
import com.padc.tunlinaung.burpplefoodstore.network.responses.GetFeaturesResponse;
import com.padc.tunlinaung.burpplefoodstore.network.responses.GetGuidesResponse;
import com.padc.tunlinaung.burpplefoodstore.network.responses.GetPromotionsResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class RetrofitDataAgent implements FeaturesDataAgent, PromotionsDataAgent, GuidesDataAgent {

    private static RetrofitDataAgent sObjInstance;
    private FeaturesApi mFeaturesApi;
    private PromotionsApi mPromotionsApi;
    private GuidesApi mGuidesApi;

    private RetrofitDataAgent() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mFeaturesApi = retrofit.create(FeaturesApi.class);
        mPromotionsApi = retrofit.create(PromotionsApi.class);
        mGuidesApi = retrofit.create(GuidesApi.class);
    }

    public static RetrofitDataAgent getObjInstance() {
        if (sObjInstance == null)
            sObjInstance = new RetrofitDataAgent();

        return sObjInstance;
    }

    @Override
    public void loadFeatures() {
        Call<GetFeaturesResponse> getNewsResponseCall = mFeaturesApi.getFeatures("b002c7e1a528b7cb460933fc2875e916", 1);

        getNewsResponseCall.enqueue(new Callback<GetFeaturesResponse>() {
            @Override
            public void onResponse(Call<GetFeaturesResponse> call, Response<GetFeaturesResponse> response)
            {
                GetFeaturesResponse getFeaturesResponse = response.body();

                if (getFeaturesResponse != null) {
                    EventBus.getDefault()  // event object
                            .post(new LoadedFeaturesEvent(getFeaturesResponse.getFeatures())); // post method
                }
            }

            @Override
            public void onFailure(Call<GetFeaturesResponse> call, Throwable t)
            {
            }
        });
    }

    @Override
    public void loadPromotions() {
        Call<GetPromotionsResponse> getPromotionsResponseCall = mPromotionsApi.getPromotions("b002c7e1a528b7cb460933fc2875e916", 1);

        getPromotionsResponseCall.enqueue(new Callback<GetPromotionsResponse>() {
            @Override
            public void onResponse(Call<GetPromotionsResponse> call, Response<GetPromotionsResponse> response)
            {
                GetPromotionsResponse getPromotionsResponse = response.body();

                if (getPromotionsResponse != null) {
                    EventBus.getDefault()  // event object
                            .post(new LoadedPromotionsEvent(getPromotionsResponse.getPromotions())); // post method
                }
            }

            @Override
            public void onFailure(Call<GetPromotionsResponse> call, Throwable t)
            {
            }
        });
    }

    @Override
    public void loadGuides() {
        Call<GetGuidesResponse> getGuidesResponseCall = mGuidesApi.getGuides("b002c7e1a528b7cb460933fc2875e916", 1);

        getGuidesResponseCall.enqueue(new Callback<GetGuidesResponse>() {
            @Override
            public void onResponse(Call<GetGuidesResponse> call, Response<GetGuidesResponse> response)
            {
                GetGuidesResponse getGuidesResponse = response.body();

                if (getGuidesResponse != null) {
                    EventBus.getDefault()  // event object
                            .post(new LoadedGuidesEvent(getGuidesResponse.getGuides())); // post method
                }
            }

            @Override
            public void onFailure(Call<GetGuidesResponse> call, Throwable t)
            {
            }
        });
    }
}
