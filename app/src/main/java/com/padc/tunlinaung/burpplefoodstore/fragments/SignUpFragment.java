package com.padc.tunlinaung.burpplefoodstore.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.padc.tunlinaung.burpplefoodstore.R;
import com.padc.tunlinaung.burpplefoodstore.data.models.LoginUserModel;
import com.padc.tunlinaung.burpplefoodstore.events.SuccessLoginEvent;
import com.padc.tunlinaung.burpplefoodstore.events.SuccessRegisterEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by eidoshack on 1/24/18.
 */

public class SignUpFragment extends Fragment {

    @BindView(R.id.et_first_name)
    EditText etFirstName;

    @BindView(R.id.et_last_name)
    EditText etLastName;

    @BindView(R.id.et_email)
    EditText etEmail;

    @BindView(R.id.et_phoneno)
    EditText etPhoneNo;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.et_confirm_password)
    EditText etConfirmPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.btn_sign_up)
    public void onTapSignUp(View view)
    {
        String phoneNo = etPhoneNo.getText().toString();
        String password = etPassword.getText().toString();
        String name = etFirstName.getText().toString() + " " + etLastName.getText().toString();

        LoginUserModel.getInstance().registerUser(phoneNo, password, name);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRegisterUserSuccess(SuccessRegisterEvent event) {
        if (getActivity() != null)
            getActivity().onBackPressed();


    }
}
