package com.padc.tunlinaung.burpplefoodstore.data.models;

import com.padc.tunlinaung.burpplefoodstore.network.PromotionsDataAgent;
import com.padc.tunlinaung.burpplefoodstore.network.RetrofitDataAgent;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class PromotionsModel {

    private static PromotionsModel sObjInstance;

    private PromotionsDataAgent mPromotionsDataAgent;

    private PromotionsModel() {
        mPromotionsDataAgent = RetrofitDataAgent.getObjInstance();
    }

    public static PromotionsModel getObjInstance() {
        if (sObjInstance == null)
            sObjInstance = new PromotionsModel();

        return sObjInstance;
    }

    public void loadPromotions() {
        mPromotionsDataAgent.loadPromotions();
    }
}
