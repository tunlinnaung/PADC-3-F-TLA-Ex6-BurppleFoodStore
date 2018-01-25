package com.padc.tunlinaung.burpplefoodstore.viewpod;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.data.vo.LoginUserVO;
import com.padc.tunlinaung.burpplefoodstore.delegates.AfterLoginDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by eidoshack on 1/25/18.
 */

public class AfterLoginViewPod extends RelativeLayout {

    @BindView(R.id.iv_login_profile)
    ImageView ivLoginProfile;

    @BindView(R.id.tv_login_username)
    TextView tvLoginUserName;

    @BindView(R.id.tv_login_phoneno)
    TextView tvLoginPhoneNo;

    private AfterLoginDelegate mDelegate;

    public AfterLoginViewPod(Context context) {
        super(context);
    }

    public AfterLoginViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AfterLoginViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDelegate(AfterLoginDelegate mDelegate) {
        this.mDelegate = mDelegate;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void bindData(LoginUserVO loginUser) {
        tvLoginUserName.setText(loginUser.getName());
        tvLoginPhoneNo.setText(loginUser.getPhoneNo());
    }

    @OnClick(R.id.btn_logout)
    public void onTapLogout() {
        mDelegate.onTapLogout();
    }

}
