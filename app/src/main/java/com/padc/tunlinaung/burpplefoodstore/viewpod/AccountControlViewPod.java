package com.padc.tunlinaung.burpplefoodstore.viewpod;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.data.models.LoginUserModel;
import com.padc.tunlinaung.burpplefoodstore.delegates.AfterLoginDelegate;
import com.padc.tunlinaung.burpplefoodstore.delegates.BeforeLoginDelegate;
import com.padc.tunlinaung.burpplefoodstore.events.SuccessLoginEvent;
import com.padc.tunlinaung.burpplefoodstore.events.SuccessRegisterEvent;
import com.padc.tunlinaung.burpplefoodstore.events.UserLogoutEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eidoshack on 1/24/18.
 */

public class AccountControlViewPod extends FrameLayout {

    @BindView(R.id.vp_before_login_user)
    BeforeLoginViewPod vpBeforeLogin;

    @BindView(R.id.vp_after_login_user)
    AfterLoginViewPod vpAfterLogin;

    public AccountControlViewPod(@NonNull Context context) {
        super(context);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDelegate(BeforeLoginDelegate delegate) {
        vpBeforeLogin.setDelegate(delegate);
    }

    public void setDelegate(AfterLoginDelegate delegate) {
        vpAfterLogin.setDelegate(delegate);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this, this);

        EventBus.getDefault().register(this);

        refreshUserSession();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        vpBeforeLogin.setVisibility(GONE);
        vpAfterLogin.setVisibility(VISIBLE);

        vpAfterLogin.bindData(event.getmLoginUser());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRegisterUserSuccess(SuccessRegisterEvent event) {
        vpBeforeLogin.setVisibility(GONE);
        vpAfterLogin.setVisibility(VISIBLE);

        vpAfterLogin.bindData(event.getmRegisterUser());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLogoutUser(UserLogoutEvent event) {
        vpBeforeLogin.setVisibility(VISIBLE);
        vpAfterLogin.setVisibility(GONE);
    }

    public void refreshUserSession() {
        if (LoginUserModel.getInstance().isUserLogin()) {
            vpBeforeLogin.setVisibility(GONE);
            vpAfterLogin.setVisibility(VISIBLE);
        }
        else
        {
            vpBeforeLogin.setVisibility(VISIBLE);
            vpAfterLogin.setVisibility(GONE);
        }
    }
}
