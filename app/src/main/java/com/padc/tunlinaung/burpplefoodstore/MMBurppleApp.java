package com.padc.tunlinaung.burpplefoodstore;

import android.app.Application;

import com.padc.tunlinaung.burpplefoodstore.network.RetrofitDataAgent;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class MMBurppleApp extends Application
{
    public static final String LOG_TAG = "MMBurppleApp";

    @Override
    public void onCreate() {
        super.onCreate();
        //RetrofitDataAgent.getInstance();
    }

}
