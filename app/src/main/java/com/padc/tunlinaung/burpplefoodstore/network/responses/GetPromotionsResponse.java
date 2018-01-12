package com.padc.tunlinaung.burpplefoodstore.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.tunlinaung.burpplefoodstore.data.vo.PromotionsVO;

import java.util.List;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class GetPromotionsResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<PromotionsVO> promotions;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<PromotionsVO> getPromotions() {
        return promotions;
    }
}
