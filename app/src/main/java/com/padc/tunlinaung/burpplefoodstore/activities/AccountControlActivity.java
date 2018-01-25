package com.padc.tunlinaung.burpplefoodstore.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.fragments.LoginFragment;
import com.padc.tunlinaung.burpplefoodstore.fragments.SignUpFragment;

import butterknife.ButterKnife;

/**
 * Created by eidoshack on 1/24/18.
 */

public class AccountControlActivity extends AppCompatActivity {

    public static final String IE_SCREEN_TYPE    = "IE_SCREEN_TYPE";
    public static final int SCREEN_TYPE_LOGIN    = 1;
    public static final int SCREEN_TYPE_REGISTER = 2;

    Fragment fragment;

    public static final Intent newIntentLogin(Context context) {
        Intent intent = new Intent(context, AccountControlActivity.class);
        intent.putExtra(IE_SCREEN_TYPE, SCREEN_TYPE_LOGIN);
        return intent;
    }

    public static final Intent newIntentRegister(Context context) {
        Intent intent = new Intent(context, AccountControlActivity.class);
        intent.putExtra(IE_SCREEN_TYPE, SCREEN_TYPE_REGISTER);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_control);

        ButterKnife.bind(this, this);

        int screenType = getIntent().getIntExtra(IE_SCREEN_TYPE, -1);
        if (screenType == SCREEN_TYPE_LOGIN) {
            fragment = new LoginFragment();
        } else if (screenType == SCREEN_TYPE_REGISTER) {
            fragment = new SignUpFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
    }
}
