package com.padc.tunlinaung.burpplefoodstore.events;

import com.padc.tunlinaung.burpplefoodstore.data.vo.LoginUserVO;

/**
 * Created by eidoshack on 1/25/18.
 */

public class SuccessRegisterEvent {

    private LoginUserVO mRegisterUser;

    public SuccessRegisterEvent(LoginUserVO mRegisterUser) {
        this.mRegisterUser = mRegisterUser;
    }

    public LoginUserVO getmRegisterUser() {
        return mRegisterUser;
    }
}
