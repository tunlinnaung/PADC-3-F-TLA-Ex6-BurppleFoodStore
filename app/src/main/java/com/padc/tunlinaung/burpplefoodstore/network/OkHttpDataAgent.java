package com.padc.tunlinaung.burpplefoodstore.network;

import android.os.AsyncTask;
import android.util.Log;

import com.padc.tunlinaung.burpplefoodstore.MMBurppleApp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class OkHttpDataAgent implements FeaturesDataAgent, PromotionsDataAgent, GuidesDataAgent {

    private static OkHttpDataAgent sObjInstance;

    private static OkHttpClient mHttpClient;

    private OkHttpDataAgent() {
        // connectionTimeout - 15
        // writeTimeout - 15
        // readTimeout - 60
        mHttpClient = new OkHttpClient.Builder() //1.
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpDataAgent getObjInstance() {
        if (sObjInstance == null)
            sObjInstance = new OkHttpDataAgent();

        return sObjInstance;
    }

    @Override
    public void loadFeatures() {
        new LoadFeaturesTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getFeatured.php");
    }

    @Override
    public void loadPromotions() {
        new LoadPromotionsTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getPromotions.php");
    }

    @Override
    public void loadGuides() {
        new LoadGuidesTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getGuides.php");
    }

    static String getResponseStringFromUrls(String[] urls, String accessToken, String page) {
        String url = urls[0];

        RequestBody formBody = new FormBody.Builder() //2.
                .add("access_token", accessToken)
                .add("page", page)
                .build();

        Request request = new Request.Builder() //3
                .url(url)
                .post(formBody)
                .build();

        String responseString = null;
        try {
            Response response = mHttpClient.newCall(request).execute(); //4.
            if (response.isSuccessful() && response.body() != null) {
                responseString = response.body().string();
                return responseString;
            }
        } catch (IOException e) {
            Log.e(MMBurppleApp.LOG_TAG, e.getMessage());
        }

        return responseString;
    }

    private static class LoadFeaturesTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            return OkHttpDataAgent.getResponseStringFromUrls(urls, "b002c7e1a528b7cb460933fc2875e916", "1");
        }
    }

    private static class LoadPromotionsTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            return OkHttpDataAgent.getResponseStringFromUrls(urls, "b002c7e1a528b7cb460933fc2875e916", "1");
        }
    }

    private static class LoadGuidesTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            return OkHttpDataAgent.getResponseStringFromUrls(urls, "b002c7e1a528b7cb460933fc2875e916", "1");
        }
    }
}