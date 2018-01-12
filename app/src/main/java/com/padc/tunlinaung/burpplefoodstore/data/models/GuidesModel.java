package com.padc.tunlinaung.burpplefoodstore.data.models;

import com.padc.tunlinaung.burpplefoodstore.network.GuidesDataAgent;
import com.padc.tunlinaung.burpplefoodstore.network.RetrofitDataAgent;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class GuidesModel {

    private static GuidesModel sObjInstance;

    private GuidesDataAgent mGuidesDataAgent;

    private GuidesModel() {
        mGuidesDataAgent = RetrofitDataAgent.getObjInstance();
    }

    public static GuidesModel getObjInstance() {
        if (sObjInstance == null)
            sObjInstance = new GuidesModel();

        return sObjInstance;
    }

    public void loadGuides() {
        mGuidesDataAgent.loadGuides();
    }
}
