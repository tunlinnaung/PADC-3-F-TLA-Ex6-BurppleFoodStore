package com.padc.tunlinaung.burpplefoodstore.data.models;

import com.padc.tunlinaung.burpplefoodstore.data.vo.LoginUserVO;
import com.padc.tunlinaung.burpplefoodstore.events.SuccessLoginEvent;
import com.padc.tunlinaung.burpplefoodstore.events.SuccessRegisterEvent;
import com.padc.tunlinaung.burpplefoodstore.events.UserLogoutEvent;
import com.padc.tunlinaung.burpplefoodstore.network.RetrofitDataAgent;
import com.padc.tunlinaung.burpplefoodstore.network.responses.LoginDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by eidoshack on 1/25/18.
 */

public class LoginUserModel {

    private static LoginUserModel loginUserModel;

    private LoginDataAgent mLoginDataAgent;

    private LoginUserVO mLoginUserVO;

    private LoginUserVO mRegisterUserVO;

    private LoginUserModel() {
        mLoginDataAgent = RetrofitDataAgent.getObjInstance();

        EventBus.getDefault().register(this);
    }

    public static LoginUserModel getInstance() {
        if (loginUserModel == null)
            loginUserModel = new LoginUserModel();

        return loginUserModel;
    }

    public void loginUser(String phoneNo, String password) {
        mLoginDataAgent.loginUser(phoneNo, password);
    }

    public void registerUser(String phoneNo, String password, String name) {
        mLoginDataAgent.registerUser(phoneNo, password, name);
    }

    public boolean isUserLogin() {
        return mLoginUserVO != null;
    }

    public void logout() {
        mLoginUserVO = null;
        UserLogoutEvent event = new UserLogoutEvent();
        EventBus.getDefault().post(event);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        mLoginUserVO = event.getmLoginUser();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onRegisterUserSuccess(SuccessRegisterEvent event) {
        mRegisterUserVO = event.getmRegisterUser();
    }

}
