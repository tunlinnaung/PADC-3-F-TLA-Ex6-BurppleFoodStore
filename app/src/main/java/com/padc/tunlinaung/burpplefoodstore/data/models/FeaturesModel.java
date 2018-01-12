package com.padc.tunlinaung.burpplefoodstore.data.models;

import com.padc.tunlinaung.burpplefoodstore.network.FeaturesDataAgent;
import com.padc.tunlinaung.burpplefoodstore.network.RetrofitDataAgent;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class FeaturesModel {

    private static FeaturesModel sObjInstance;

    private FeaturesDataAgent mFeaturesDataAgent;

    private FeaturesModel() {
        mFeaturesDataAgent = RetrofitDataAgent.getObjInstance();
    }

    public static FeaturesModel getObjInstance() {
        if (sObjInstance == null)
            sObjInstance = new FeaturesModel();

        return sObjInstance;
    }

    public void loadFeatures() {
        mFeaturesDataAgent.loadFeatures();
    }

}
