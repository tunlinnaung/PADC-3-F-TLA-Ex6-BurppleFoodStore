package com.padc.tunlinaung.burpplefoodstore.events;

import com.padc.tunlinaung.burpplefoodstore.data.vo.PromotionsVO;

import java.util.List;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class LoadedPromotionsEvent {

    private List<PromotionsVO> promotions;

    public LoadedPromotionsEvent(List<PromotionsVO> promotions) {
        this.promotions = promotions;
    }

    public List<PromotionsVO> getPromotions() {
        return promotions;
    }
}
