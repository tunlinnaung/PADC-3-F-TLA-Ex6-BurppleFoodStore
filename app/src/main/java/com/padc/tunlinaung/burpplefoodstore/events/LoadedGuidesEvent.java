package com.padc.tunlinaung.burpplefoodstore.events;

import com.padc.tunlinaung.burpplefoodstore.data.vo.GuidesVO;

import java.util.List;

/**
 * Created by techfunmmr on 1/12/2018.
 */

public class LoadedGuidesEvent {

    private List<GuidesVO> guides;

    public LoadedGuidesEvent(List<GuidesVO> guides) {
        this.guides = guides;
    }

    public List<GuidesVO> getGuides() {
        return guides;
    }
}
