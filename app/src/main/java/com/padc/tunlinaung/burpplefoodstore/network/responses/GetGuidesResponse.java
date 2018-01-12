package com.padc.tunlinaung.burpplefoodstore.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.tunlinaung.burpplefoodstore.data.vo.GuidesVO;

import java.util.List;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class GetGuidesResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;
    @SerializedName("featured")
    private List<GuidesVO> guides;

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

    public List<GuidesVO> getGuides() {
        return guides;
    }
}
