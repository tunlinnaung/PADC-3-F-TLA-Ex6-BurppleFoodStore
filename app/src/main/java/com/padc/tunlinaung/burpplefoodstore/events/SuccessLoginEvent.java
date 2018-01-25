package com.padc.tunlinaung.burpplefoodstore.events;

import com.padc.tunlinaung.burpplefoodstore.data.vo.LoginUserVO;

/**
 * Created by eidoshack on 1/25/18.
 */

public class SuccessLoginEvent {

    private LoginUserVO mLoginUser;

    public SuccessLoginEvent(LoginUserVO mLoginUser) {
        this.mLoginUser = mLoginUser;
    }

    public LoginUserVO getmLoginUser() {
        return mLoginUser;
    }
}
