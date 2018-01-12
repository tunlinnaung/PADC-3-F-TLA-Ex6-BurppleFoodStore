package com.padc.tunlinaung.burpplefoodstore.events;

import com.padc.tunlinaung.burpplefoodstore.data.vo.FeaturesVO;

import java.util.List;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class LoadedFeaturesEvent {

    private List<FeaturesVO> features;

    public LoadedFeaturesEvent(List<FeaturesVO> features) {
        this.features = features;
    }

    public List<FeaturesVO> getFeatures() {
        return features;
    }
}
